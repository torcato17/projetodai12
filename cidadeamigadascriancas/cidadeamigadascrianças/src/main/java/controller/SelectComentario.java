package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Comentario;

public class SelectComentario {

	// conecta a base de dados
		String DRIVER = "com.mysql.jdbc.Driver";
		// diz que o host é o mysql
		String URL = "jdbc:mysql://remotemysql.com:3306";
		String USER = "d4YWRRmazE";
		String PASSWORD = "0HMMHO3mbT";
		String sql = "SELECT * FROM  d4YWRRmazE.comentario where id_comentario = ?";
		ResultSet rs;
	
		Comentario com = new Comentario();
		public Comentario retornaComentario(Comentario come) {
			try {
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, come.getId_comentario());
				rs = st.executeQuery();
				// executeUpdate(); se for um update
				rs.next();
				// avança no array em ves de criar um vazio

				String comentario = rs.getString("comentario");
				come.setComentario(comentario);
				Integer avaliacao = rs.getInt("avaliacao");
				come.setAvaliacao(avaliacao);
				Date datacom = rs.getDate("data");
	            come.setData(datacom);
				

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return come;
		}
}
