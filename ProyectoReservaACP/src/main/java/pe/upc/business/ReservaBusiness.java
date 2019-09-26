package pe.upc.business;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import pe.upc.model.entity.Reserva;
import pe.upc.model.repository.ReservaRepository;

@Named
public class ReservaBusiness implements Serializable {
private static final long serialVersionUID = 6L;
	
	@Inject
	private ReservaRepository ReservaRepository;

	@Transactional
	public Long insert(Reserva reserva) throws Exception {
		return ReservaRepository.insert(reserva);
	}

	
	@Transactional
	public Long update(Reserva reserva) throws Exception{
		return ReservaRepository.update(reserva);
	}
	
	
	public List<Reserva> getAll() throws Exception {
		return ReservaRepository.findAll();
	}
		
}
