package com.example.thymeleaf.service.impl;

import com.example.thymeleaf.domain.Room;
import com.example.thymeleaf.domain.WindowBlind;
import com.example.thymeleaf.intersection_table.WindowBlindRoomInt;
import com.example.thymeleaf.repository.RoomRepository;
import com.example.thymeleaf.repository.WindowBlindRepository;
import com.example.thymeleaf.repository.WindowBlindRoomIntRepository;
import com.example.thymeleaf.service.WindowBlindRoomIntService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public class WindowBlindRoomIntServiceImpl implements WindowBlindRoomIntService {
    private final WindowBlindRoomIntRepository windowBlindRoomIntRepository;
    private final WindowBlindRepository windowBlindRepository;
    private final RoomRepository roomRepository;

    public WindowBlindRoomIntServiceImpl(WindowBlindRoomIntRepository windowBlindRoomIntRepository, WindowBlindRepository windowBlindRepository, RoomRepository roomRepository) {
        this.windowBlindRoomIntRepository = windowBlindRoomIntRepository;
        this.windowBlindRepository = windowBlindRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public WindowBlindRoomInt saveWindowBlindRoomInt(WindowBlindRoomInt windowBlindRoomInt) {
        return windowBlindRoomIntRepository.save(windowBlindRoomInt);
    }

    @Override
    public List<WindowBlindRoomInt> findAll() {
        List<WindowBlindRoomInt> windowBlindList = windowBlindRoomIntRepository.findAll();
        System.out.println(windowBlindList);
        return windowBlindList;
    }

    @Override
    public Optional<WindowBlindRoomInt> findById(Long id) {
        return windowBlindRoomIntRepository.findById(id);
    }

    @Override
    public WindowBlindRoomInt assignWindowBlindToRoom(Long windowBlindId, Long roomId) {
        WindowBlindRoomInt windowBlindRoomInt = new WindowBlindRoomInt();
        WindowBlind windowBlindTofind = windowBlindRepository.findById(windowBlindId).orElseThrow();
        Room roomToFind = roomRepository.findById(roomId).orElseThrow();
        windowBlindRoomInt.setWindowBlindId(windowBlindTofind);
        windowBlindRoomInt.setRoomId(roomToFind);
        return saveWindowBlindRoomInt(windowBlindRoomInt);
    }

    @Override
    public WindowBlindRoomInt setWindowBlindInRoom(Long id, Integer opened) {
        WindowBlindRoomInt windowBlindRoomInt = windowBlindRoomIntRepository.findById(id).orElseThrow();
        if(opened >= 0 && opened <= 100) {
            windowBlindRoomInt.setOpened(opened);
        } else {
            System.out.println("Deschiderea trebuie sa fie cuprinsa intre 0 si 100");
        }
        return saveWindowBlindRoomInt(windowBlindRoomInt);
    }

    @Override
    public void timer(Long windowBlindId, String hourIn, String minIn, Integer opened) {
        Timer timer = new Timer(true);
        int hour = Integer.parseInt(hourIn);
        int min = Integer.parseInt(minIn);
        int sec= 2;
        WindowBlindRoomInt windowBlindRoomInt = windowBlindRoomIntRepository.findById(windowBlindId).orElseThrow();
        windowBlindRoomInt.setTimer(hour + ":" + min);
        saveWindowBlindRoomInt(windowBlindRoomInt);
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
                    setWindowBlindHourOpened(windowBlindId, hourIn, minIn, opened);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        timer.schedule(task, d);
    }

    public WindowBlindRoomInt setWindowBlindHourOpened(Long windowBlindId, String hour, String min, Integer opened) throws InterruptedException {
        int hourIn = Integer.parseInt(hour);
        int minIn = Integer.parseInt(min);
        WindowBlindRoomInt windowBlindRoomInt = windowBlindRoomIntRepository.findById(windowBlindId).orElseThrow();
        if (hourIn == LocalTime.now().getHour()) {
            if (minIn == LocalTime.now().getMinute()) {
                windowBlindRoomInt.setOpened(opened);
            }
        } else {
            System.out.println("Se asteapta ora.");
        }
        return saveWindowBlindRoomInt(windowBlindRoomInt);
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
@Override
    public void deleteById(Long id) {
        windowBlindRoomIntRepository.deleteById(id);
    }

}
