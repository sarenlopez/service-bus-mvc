package mx.com.ege.bus.repo;

import java.sql.Blob;

import org.springframework.stereotype.Repository;

@Repository
public interface ReclamoDao {
	
	public int insertaReclamo(String tipoReclamoDesc, String numSiniestro, int empresa, int contratante, int aseguradora, String poliza, int certificado);
	
	public boolean insertaReclamoDocto(int tipoReclamoId, int reclamoId, String archivoNombre, String archivo );
}
