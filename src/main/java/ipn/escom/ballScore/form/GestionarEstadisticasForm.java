package ipn.escom.ballScore.form;

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
	

}
