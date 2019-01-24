package it.linksmt.teamshare.business.request;

import java.io.Serializable;
import java.util.List;

import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.business.dtos.UserDto;

public class DashboardEntryRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2698500614468595704L;

		private UserDto utente;
		
		private List<ActivityDto> attivita;

		public UserDto getUtente() {
			return utente;
		}

		public void setUtente(UserDto utente) {
			this.utente = utente;
		}

		public List<ActivityDto> getAttivita() {
			return attivita;
		}

		public void setAttivita(List<ActivityDto> attivita) {
			this.attivita = attivita;
		}

	
		
}
