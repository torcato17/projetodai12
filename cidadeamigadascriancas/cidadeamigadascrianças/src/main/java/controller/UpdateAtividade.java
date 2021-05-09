package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Atividade;

public class UpdateAtividade {

	//conecta a base de dados
	String DRIVER = "com.mysql.jdbc.Driver";
	// diz que o host � o mysql
	String URL = "jdbc:mysql://remotemysql.com:3306";
	String USER = "d4YWRRmazE";
	String PASSWORD = "0HMMHO3mbT";
	String sql = "UPDATE d4YWRRmazE.atividade SET nome_atividade = ?, descricao = ?, parceiros = ?, data_i = ?, data_f = ?   WHERE id_atividade = ?";
	int i;
	
	public int atualizarAtividade(Atividade at) {
		
		String nome_atividade = at.getNomeAtividade();
		String descricao = at.getDescricao();
		String parceiros = at.getParceiro();
		Date data_i = at.getData();
		Date data_f = at.getData_fim();
		int id = at.getIdAtividade();
		
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, nome_atividade);
			st.setString(2, descricao);
			st.setString(3, parceiros);
			st.setDate(4, data_i);
			st.setDate(5, data_f);
			st.setInt(6, id);
			
			i = st.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}	
}
