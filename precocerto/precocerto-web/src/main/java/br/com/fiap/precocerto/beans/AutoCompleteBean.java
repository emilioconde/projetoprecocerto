package br.com.fiap.precocerto.beans;


import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.fiap.precocerto.conversores.Player;
import br.com.fiap.precocerto.conversores.PlayerConverter;


@ManagedBean
@RequestScoped
public class AutoCompleteBean {

	private Player selectedPlayer1;
    
    private Player selectedPlayer2;

	private List<Player> players;

	public AutoCompleteBean() {
		players = PlayerConverter.playerDB;
	}

    public Player getSelectedPlayer1() {
        return selectedPlayer1;
    }

    public void setSelectedPlayer1(Player selectedPlayer1) {
        this.selectedPlayer1 = selectedPlayer1;
    }

    public Player getSelectedPlayer2() {
        return selectedPlayer2;
    }

    public void setSelectedPlayer2(Player selectedPlayer2) {
        this.selectedPlayer2 = selectedPlayer2;
    }

	public List<Player> completePlayer(String query) {
		List<Player> suggestions = new ArrayList<Player>();
		
		for(Player p : players) {
			if(p.getName().startsWith(query))
				suggestions.add(p);
		}
		
		return suggestions;
	}
}
                    