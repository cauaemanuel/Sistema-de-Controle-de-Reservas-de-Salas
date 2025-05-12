package com.Controle_de_Salas.service.Schedule;

import com.Controle_de_Salas.ControleDeSalasApplication;
import com.Controle_de_Salas.repository.ReservaRepository;
import com.Controle_de_Salas.service.ReservaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


@Component
public class ReservaTaskSchedule {

    private static final Logger logger = LoggerFactory.getLogger(ControleDeSalasApplication.class);

    private ReservaRepository reservaRepository;

    public ReservaTaskSchedule(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public void checkAndRemove(LocalDateTime dateTime) {
        reservaRepository.checkAndRemove(dateTime);
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void runTask(){
        var dateTime = LocalDateTime.now().minusDays(1);
        logger.info("Running at {}", dateTime);
        checkAndRemove(dateTime);
    }
}
