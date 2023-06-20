package com.example.demo.fred;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RegistroRepository {

    @Query(value = "select distinct r "
            + " from VwRegistrosUnicos rw "
            + " 	left join rw.idStatus statusreg, "
            + "		Registros r "
            + " 	left join fetch r.regsVeiculosList rv "
            + " where r.idRegistro = rw.idRegistro "
            + " 	and rw.dtUltAtualiza BETWEEN ?1 and ?2 ")
    List<Registros> findRegistrosQuantitativo(Date stDate, Date edDate);

    @Query(value = "select distinct r "
            + " from VwRegistrosUnicos rw "
            + " 	left join rw.idStatus statusreg, "
            + "		Registros r "
            + " 	left join fetch r.regsVeiculosList rv "
            + " where r.idRegistro = rw.idRegistro "
            + " 	and statusreg.idStatus in(?3)"
            + " 	and rw.dtUltAtualiza BETWEEN ?1 and ?2 ")
    List<Registros> findRegistrosQuantitativo(Date stDate, Date edDate, Integer idStatus);

    @Query(value = "select distinct r "
            + " from VwRegistrosUnicos rw "
            + " 	left join rw.idStatus statusreg, "
            + "		Registros r "
            + " 	left join fetch r.regsVeiculosList rv "
            + " where r.idRegistro = rw.idRegistro "
            + "		and r.idCredor.idCredor in(?4) "
            + " 	and statusreg.idStatus in(?3)"
            + " 	and rw.dtUltAtualiza BETWEEN ?1 and ?2 ")
    List<Registros> findRegistrosQuantitativo(Date stDate, Date edDate, Integer idStatus, List<Integer> idCredores);

    @Query(value = "select distinct r "
            + " from VwRegistrosUnicos rw "
            + " 	left join rw.idStatus statusreg, "
            + "		Registros r "
            + " 	left join fetch r.regsVeiculosList rv "
            + " where r.idRegistro = rw.idRegistro "
            + "		and r.idCredor.idCredor in(?3)"
            + " 	and rw.dtUltAtualiza BETWEEN ?1 and ?2 ")
    List<Registros> findRegistrosQuantitativo(Date stDate, Date edDate, List<Integer> idCredores);

}
