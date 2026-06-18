package com.ecole.entity.Etudiant;
import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "lecon")
public class Lecon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
 
    

}
