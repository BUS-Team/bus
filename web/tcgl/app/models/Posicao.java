package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "posicoes")
public class Posicao extends Model {

	public static Finder<Long, Posicao> find = new Finder<Long, Posicao>(Long.class, Posicao.class);

	@Id
	public long id;

	public Date datahora;

	public int linha;

	public String sentido;

	public double latitude;

	public double longitude;

	public int tipo;

	public static List<Posicao> findPosicoesByRoute(int route) {
		List<Posicao> posicoes = Posicao.
				find.where().eq("linha", route).
				findPagingList(500).getAsList();
		return posicoes;
	}
}
