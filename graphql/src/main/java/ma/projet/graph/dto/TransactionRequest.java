package ma.projet.graph.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.projet.graph.entities.TypeCompte;
import ma.projet.graph.entities.TypeTransaction;

import java.util.Date;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class TransactionRequest {
        private Long compteId;
        private Double montant;
        @Temporal(TemporalType.DATE)
        private Date date;
        @Enumerated(EnumType.STRING)
        private TypeTransaction type;

        private long compte ;
    }


