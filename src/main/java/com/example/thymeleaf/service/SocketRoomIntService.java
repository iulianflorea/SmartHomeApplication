package com.example.thymeleaf.service;

import com.example.thymeleaf.domain.Room;
import com.example.thymeleaf.domain.Socket;
import com.example.thymeleaf.domain.Socket;
import com.example.thymeleaf.domain.SocketRoomInt;
import com.example.thymeleaf.repository.RoomRepository;
import com.example.thymeleaf.repository.SocketRoomIntRepository;
import com.example.thymeleaf.repository.SocketRepository;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.security.sasl.RealmCallback;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class SocketRoomIntService {
    private final SocketRoomIntRepository socketIntRepository;
    private final SocketRepository socketRepository;
    private final RoomRepository roomRepository;

    public SocketRoomIntService(SocketRoomIntRepository socketIntRepository, SocketRepository socketRepository, RoomRepository roomRepository) {
        this.socketIntRepository = socketIntRepository;
        this.socketRepository = socketRepository;
        this.roomRepository = roomRepository;
    }

    public SocketRoomInt saveSocketRoomInt(SocketRoomInt socketRoomInt) {
        return socketIntRepository.save(socketRoomInt);
    }

    public List<SocketRoomInt> findAll() {
        List<SocketRoomInt> socketsRoomInt = socketIntRepository.findAll();
        System.out.println(socketsRoomInt);
        return socketIntRepository.findAll();
    }

    public Optional<SocketRoomInt> findById(Long id) {
        return socketIntRepository.findById(id);
    }

    public SocketRoomInt assignSocketToRoom(Long socketId, Long roomId) {
        SocketRoomInt socketRoomInt = new SocketRoomInt();
        Socket socket = socketRepository.findById(socketId).orElseThrow();
        Room room = roomRepository.findById(roomId).orElseThrow();
        socketRoomInt.setSocketId(socket);
        socketRoomInt.setRoomId(room);
        return saveSocketRoomInt(socketRoomInt);
    }

    public SocketRoomInt setSocketValueToRoom(Long socketId, Boolean onOff) {
        SocketRoomInt socketRoomInt = socketIntRepository.findById(socketId).orElseThrow();
        socketRoomInt.setOnOff(onOff);
        return saveSocketRoomInt(socketRoomInt);
    }

    public void timer(Long socketId, String hourIn, String minIn) {
        Timer timer = new Timer(true);
        int hour = Integer.parseInt(hourIn);
        int min = Integer.parseInt(minIn);
        int sec= 2;
        long currentTimeMillis = System.currentTimeMillis();
        long scheduledTimeMillis = getScheduleTimeMillis(hour, min, sec, currentTimeMillis);
        System.out.println("tralalala");
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

        // ob??ine??i timpul curent ??n form?? de obiect Date
        Date currentTime = new Date(currentTimeMillis);

        // ob??ine??i timpul la care trebuie s?? fie apelat?? metoda ??n form?? de obiect Date
        Date scheduledTime = new Date(currentTime.getYear(), currentTime.getMonth(), currentTime.getDate(), hour, minute, second);

        // verifica??i dac?? ora specificat?? este dup?? ora curent??
        if (scheduledTime.after(currentTime)) {
            scheduledTimeMillis = scheduledTime.getTime();
        } else {
            scheduledTimeMillis = scheduledTime.getTime() + 24 * 60 * 60 * 1000;  // ad??uga??i o zi
        }

        return scheduledTimeMillis;
    }


}
