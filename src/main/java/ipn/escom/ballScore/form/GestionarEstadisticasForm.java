package ipn.escom.ballScore.form;

import java.util.List;

import ipn.escom.ballScore.entity.EstDefensivasPart;
import ipn.escom.ballScore.entity.EstOfensivasPart;
import ipn.escom.ballScore.entity.EstPitcherPart;

/**Form para la gestion de estadisticas
 * @author Jose Mauricio
 *
 */
public class GestionarEstadisticasForm {
	
	private Long idPartido;
	private Long idJugador;
	private Long idEquipo;
	private Long idTemporada;
	private EstadisticasPitcherVO estadisticasPitcherVO;
	private EstadisticasDefensivasVO estadisticasDefensivasVO;
	private EstadisticasOfensivasVO estadisticasOfensivasVO;
	
	private List<EstPitcherPart> estadisticasPitcher;
	private List<EstOfensivasPart> estadisticasOfensivas;
	private List<EstDefensivasPart> estadisticasDefensivas;
	
	public Long getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
	}
	public Long getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(Long idJugador) {
		this.idJugador = idJugador;
	}
	public Long getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}
	public Long getIdTemporada() {
		return idTemporada;
	}
	public void setIdTemporada(Long idTemporada) {
		this.idTemporada = idTemporada;
	}
	public EstadisticasPitcherVO getEstadisticasPitcherVO() {
		return estadisticasPitcherVO;
	}
	public void setEstadisticasPitcherVO(EstadisticasPitcherVO estadisticasPitcherVO) {
		this.estadisticasPitcherVO = estadisticasPitcherVO;
	}
	public EstadisticasDefensivasVO getEstadisticasDefensivasVO() {
		return estadisticasDefensivasVO;
	}
	public void setEstadisticasDefensivasVO(EstadisticasDefensivasVO estadisticasDefensivasVO) {
		this.estadisticasDefensivasVO = estadisticasDefensivasVO;
	}
	public EstadisticasOfensivasVO getEstadisticasOfensivasVO() {
		return estadisticasOfensivasVO;
	}
	public void setEstadisticasOfensivasVO(EstadisticasOfensivasVO estadisticasOfensivasVO) {
		this.estadisticasOfensivasVO = estadisticasOfensivasVO;
	}
	public List<EstPitcherPart> getEstadisticasPitcher() {
		return estadisticasPitcher;
	}
	public void setEstadisticasPitcher(List<EstPitcherPart> estadisticasPitcher) {
		this.estadisticasPitcher = estadisticasPitcher;
	}
	public List<EstOfensivasPart> getEstadisticasOfensivas() {
		return estadisticasOfensivas;
	}
	public void setEstadisticasOfensivas(List<EstOfensivasPart> estadisticasOfensivas) {
		this.estadisticasOfensivas = estadisticasOfensivas;
	}
	public List<EstDefensivasPart> getEstadisticasDefensivas() {
		return estadisticasDefensivas;
	}
	public void setEstadisticasDefensivas(List<EstDefensivasPart> estadisticasDefensivas) {
		this.estadisticasDefensivas = estadisticasDefensivas;
	}
	
}
