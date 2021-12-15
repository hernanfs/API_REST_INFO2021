package com.informatorio.apirestinfo.dto;

public class EventoDTO {
    private Long eventoId;
    private Long suscriptorId;

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Long getSuscriptorId() {
        return suscriptorId;
    }

    public void setSuscriptorId(Long suscriptorId) {
        this.suscriptorId = suscriptorId;
    }
}
