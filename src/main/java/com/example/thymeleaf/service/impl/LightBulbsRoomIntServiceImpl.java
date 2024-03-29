package com.example.thymeleaf.service.impl;

import com.example.thymeleaf.domain.LightBulb;
import com.example.thymeleaf.intersection_table.LightBulbsRoomInt;
import com.example.thymeleaf.domain.Room;
import com.example.thymeleaf.repository.LightBulbRepository;
import com.example.thymeleaf.repository.LightBulbsRoomIntRepository;
import com.example.thymeleaf.repository.RoomRepository;
import com.example.thymeleaf.service.LightBulbRoomIntService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public class LightBulbsRoomIntServiceImpl implements LightBulbRoomIntService {
    private final LightBulbsRoomIntRepository lightBulbsRoomIntRepository;
    private final LightBulbRepository lightBulbRepository;
    private final RoomRepository roomRepository;

    public LightBulbsRoomIntServiceImpl(LightBulbsRoomIntRepository lightBulbsRoomIntRepository, LightBulbRepository lightBulbRepository, RoomRepository roomRepository) {
        this.lightBulbsRoomIntRepository = lightBulbsRoomIntRepository;
        this.lightBulbRepository = lightBulbRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public LightBulbsRoomInt saveLightBulbsRoomInt(LightBulbsRoomInt lightBulbsRoomInt) {
        return lightBulbsRoomIntRepository.save(lightBulbsRoomInt);
    }

    @Override
    public List<LightBulbsRoomInt> findAll() {
        List<LightBulbsRoomInt> lightBulbsRoomInts = lightBulbsRoomIntRepository.findAll();
        System.out.println(lightBulbsRoomInts);
        return lightBulbsRoomIntRepository.findAll();
    }

    @Override
    public Optional<LightBulbsRoomInt> findById(Long id) {
        return lightBulbsRoomIntRepository.findById(id);
    }

    @Override
    public LightBulbsRoomInt assignLightBulbsToRoom(Long lightBulbId, Long roomId) {
        LightBulbsRoomInt lightBulbsRoomInt = new LightBulbsRoomInt();
        LightBulb lightBulb = lightBulbRepository.findById(lightBulbId).orElseThrow();
        Room room = roomRepository.findById(roomId).orElseThrow();
        lightBulbsRoomInt.setLightBulbId(lightBulb);
        lightBulbsRoomInt.setRoomId(room);
        return saveLightBulbsRoomInt(lightBulbsRoomInt);
    }

    @Override
    public LightBulbsRoomInt setLightBulbValueToRoom(Long lightBulbsId, Integer intensity, Boolean onOff) {
        LightBulbsRoomInt lightBulbsRoomInt = lightBulbsRoomIntRepository.findById(lightBulbsId).orElseThrow();
        if (intensity >= 0 && intensity <= 100) {
            lightBulbsRoomInt.setIntensity(intensity);
        } else {
            System.out.println("Intensitatea trebuie sa fie cuprinsa intre 0 si 100");
        }
        lightBulbsRoomInt.setOnOff(onOff);
        return saveLightBulbsRoomInt(lightBulbsRoomInt);
    }

    @Override
    public void timer(Long lightBulbId, String hourIn, String minIn) {
        Timer timer = new Timer(true);
        int hour = Integer.parseInt(hourIn);
        int min = Integer.parseInt(minIn);
        int sec= 0;
        long currentTimeMillis = System.currentTimeMillis();
        long scheduledTimeMillis = getScheduleTimeMillis(hour, min, sec, currentTimeMillis);

        LightBulbsRoomInt lightBulbsRoomInt = lightBulbsRoomIntRepository.findById(lightBulbId).orElseThrow();
        lightBulbsRoomInt.setHourOnOff(hour + ":" + min);
        saveLightBulbsRoomInt(lightBulbsRoomInt);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, min);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        Date d = cal.getTime();
        System.out.println(d);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    setLightBulbHourOn(lightBulbId, hourIn, minIn);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        timer.schedule(task, d);
    }


    public LightBulbsRoomInt setLightBulbHourOn(Long lightBulbId, String hour, String min) throws InterruptedException {
        int hourIn = Integer.parseInt(hour);
        int minIn = Integer.parseInt(min);
        LightBulbsRoomInt lightBulbsRoomInt = lightBulbsRoomIntRepository.findById(lightBulbId).orElseThrow();
        if (hourIn == LocalTime.now().getHour()) {
            if (minIn == LocalTime.now().getMinute()) {
                lightBulbsRoomInt.setOnOff(true);
            }
        } else {
            lightBulbsRoomInt.setOnOff(false);
        }
        lightBulbsRoomInt.setHourOnOff(hour + ":" + min);
        return saveLightBulbsRoomInt(lightBulbsRoomInt);
    }

    public static long getScheduleTimeMillis(int hour, int minute, int second, long currentTimeMillis) {
        long scheduledTimeMillis = 0;

        // obțineți timpul curent în formă de obiect Date
        Date currentTime = new Date(currentTimeMillis);

        // obțineți timpul la care trebuie să fie apelată metoda în formă de obiect Date
        Date scheduledTime = new Date(currentTime.getYear(), currentTime.getMonth(), currentTime.getDate(), hour, minute, second);

        // verificați dacă ora specificată este după ora curentă
        if (scheduledTime.after(currentTime)) {
            scheduledTimeMillis = scheduledTime.getTime();
        } else {
            scheduledTimeMillis = scheduledTime.getTime() + 24 * 60 * 60 * 1000;  // adăugați o zi
        }

        return scheduledTimeMillis;
    }


    public void deleteById(Long id) {
        lightBulbsRoomIntRepository.deleteById(id);
    }
}
