package ipn.escom.ballScore.form;

import java.io.Serializable;
import java.util.List;

import ipn.escom.ballScore.entity.EstDefensivasPart;
import ipn.escom.ballScore.entity.EstOfensivasPart;
import ipn.escom.ballScore.entity.EstPitcherPart;

/**Form para la gestion de estadisticas
 * @author Jose Mauricio
 *
 */
public class GestionarEstadisticasForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
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
	/**
	 * @return El campo idPartido
	 */
	public Long getIdPartido() {
		return idPartido;
	}
	/**
	 * @param idPartido El campo idPartido a settear
	 */
	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
	}
	/**
	 * @return El campo idJugador
	 */
	public Long getIdJugador() {
		return idJugador;
	}
	/**
	 * @param idJugador El campo idJugador a settear
	 */
	public void setIdJugador(Long idJugador) {
		this.idJugador = idJugador;
	}
	/**
	 * @return El campo idEquipo
	 */
	public Long getIdEquipo() {
		return idEquipo;
	}
	/**
	 * @param idEquipo El campo idEquipo a settear
	 */
	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}
	/**
	 * @return El campo idTemporada
	 */
	public Long getIdTemporada() {
		return idTemporada;
	}
	/**
	 * @param idTemporada El campo idTemporada a settear
	 */
	public void setIdTemporada(Long idTemporada) {
		this.idTemporada = idTemporada;
	}
	/**
	 * @return El campo estadisticasPitcherVO
	 */
	public EstadisticasPitcherVO getEstadisticasPitcherVO() {
		return estadisticasPitcherVO;
	}
	/**
	 * @param estadisticasPitcherVO El campo estadisticasPitcherVO a settear
	 */
	public void setEstadisticasPitcherVO(EstadisticasPitcherVO estadisticasPitcherVO) {
		this.estadisticasPitcherVO = estadisticasPitcherVO;
	}
	/**
	 * @return El campo estadisticasDefensivasVO
	 */
	public EstadisticasDefensivasVO getEstadisticasDefensivasVO() {
		return estadisticasDefensivasVO;
	}
	/**
	 * @param estadisticasDefensivasVO El campo estadisticasDefensivasVO a settear
	 */
	public void setEstadisticasDefensivasVO(EstadisticasDefensivasVO estadisticasDefensivasVO) {
		this.estadisticasDefensivasVO = estadisticasDefensivasVO;
	}
	/**
	 * @return El campo estadisticasOfensivasVO
	 */
	public EstadisticasOfensivasVO getEstadisticasOfensivasVO() {
		return estadisticasOfensivasVO;
	}
	/**
	 * @param estadisticasOfensivasVO El campo estadisticasOfensivasVO a settear
	 */
	public void setEstadisticasOfensivasVO(EstadisticasOfensivasVO estadisticasOfensivasVO) {
		this.estadisticasOfensivasVO = estadisticasOfensivasVO;
	}
	/**
	 * @return El campo estadisticasPitcher
	 */
	public List<EstPitcherPart> getEstadisticasPitcher() {
		return estadisticasPitcher;
	}
	/**
	 * @param estadisticasPitcher El campo estadisticasPitcher a settear
	 */
	public void setEstadisticasPitcher(List<EstPitcherPart> estadisticasPitcher) {
		this.estadisticasPitcher = estadisticasPitcher;
	}
	/**
	 * @return El campo estadisticasOfensivas
	 */
	public List<EstOfensivasPart> getEstadisticasOfensivas() {
		return estadisticasOfensivas;
	}
	/**
	 * @param estadisticasOfensivas El campo estadisticasOfensivas a settear
	 */
	public void setEstadisticasOfensivas(List<EstOfensivasPart> estadisticasOfensivas) {
		this.estadisticasOfensivas = estadisticasOfensivas;
	}
	/**
	 * @return El campo estadisticasDefensivas
	 */
	public List<EstDefensivasPart> getEstadisticasDefensivas() {
		return estadisticasDefensivas;
	}
	/**
	 * @param estadisticasDefensivas El campo estadisticasDefensivas a settear
	 */
	public void setEstadisticasDefensivas(List<EstDefensivasPart> estadisticasDefensivas) {
		this.estadisticasDefensivas = estadisticasDefensivas;
	}
	
	
}
