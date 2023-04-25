package com.example.thymeleaf.service.impl;

import com.example.thymeleaf.domain.Room;
import com.example.thymeleaf.domain.Socket;
import com.example.thymeleaf.intersection_table.SocketRoomInt;
import com.example.thymeleaf.repository.RoomRepository;
import com.example.thymeleaf.repository.SocketRoomIntRepository;
import com.example.thymeleaf.repository.SocketRepository;
import com.example.thymeleaf.service.SocketRoomIntService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public class SocketRoomIntServiceImpl implements SocketRoomIntService {
    private final SocketRoomIntRepository socketIntRepository;
    private final SocketRepository socketRepository;
    private final RoomRepository roomRepository;

    public SocketRoomIntServiceImpl(SocketRoomIntRepository socketIntRepository, SocketRepository socketRepository, RoomRepository roomRepository) {
        this.socketIntRepository = socketIntRepository;
        this.socketRepository = socketRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public SocketRoomInt saveSocketRoomInt(SocketRoomInt socketRoomInt) {
        return socketIntRepository.save(socketRoomInt);
    }

    @Override
    public List<SocketRoomInt> findAll() {
        List<SocketRoomInt> socketsRoomInt = socketIntRepository.findAll();
        System.out.println(socketsRoomInt);
        return socketIntRepository.findAll();
    }

    @Override
    public Optional<SocketRoomInt> findById(Long id) {
        return socketIntRepository.findById(id);
    }

    @Override
    public SocketRoomInt assignSocketToRoom(Long socketId, Long roomId) {
        SocketRoomInt socketRoomInt = new SocketRoomInt();
        Socket socket = socketRepository.findById(socketId).orElseThrow();
        Room room = roomRepository.findById(roomId).orElseThrow();
        socketRoomInt.setSocketId(socket);
        socketRoomInt.setRoomId(room);
        return saveSocketRoomInt(socketRoomInt);
    }

    @Override
    public SocketRoomInt setSocketValueToRoom(Long socketId, Boolean onOff) {
        SocketRoomInt socketRoomInt = socketIntRepository.findById(socketId).orElseThrow();
        socketRoomInt.setOnOff(onOff);
        return saveSocketRoomInt(socketRoomInt);
    }

    @Override
    public void timer(Long socketId, String hourIn, String minIn) {
        Timer timer = new Timer(true);
        int hour = Integer.parseInt(hourIn);
        int min = Integer.parseInt(minIn);
        int sec= 0;
        long currentTimeMillis = System.currentTimeMillis();
        long scheduledTimeMillis = getScheduleTimeMillis(hour, min, sec, currentTimeMillis);
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
                    System.out.println("IN TRY");
                    setSocketHourOn(socketId, hourIn, minIn);
                    System.out.println("A rulat");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        timer.schedule(task, d);
    }


    public SocketRoomInt setSocketHourOn(Long socketId, String hour, String min) throws InterruptedException {
        int hourIn = Integer.parseInt(hour);
        int minIn = Integer.parseInt(min);
        SocketRoomInt socketRoomInt = socketIntRepository.findById(socketId).orElseThrow();
        if (hourIn == LocalTime.now().getHour()) {
            if (minIn == LocalTime.now().getMinute()) {
                socketRoomInt.setOnOff(true);
            }
        } else {
            socketRoomInt.setOnOff(false);
        }
        socketRoomInt.setHourOnOff(hour + ":" + min);
        return saveSocketRoomInt(socketRoomInt);
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


}
