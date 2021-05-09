package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Atividade;

public class InsertAtividade {

	//conecta a base de dados
			String DRIVER = "com.mysql.jdbc.Driver";
			// diz que o host é o mysql
			String URL = "jdbc:mysql://remotemysql.com:3306";
			String USER = "d4YWRRmazE";
			String PASSWORD = "0HMMHO3mbT";
			String sql = "INSERT INTO d4YWRRmazE.atividade(nome_atividade, data_i, data_f, descricao, parceiros, concelho, id_instituicao) VALUE (?,?,?,?,?,?,?)"; 
			
			Atividade atv = new Atividade();
			
			int resposta;
			public int criarAtividade(Atividade at) {
				
				String nome_atividade = at.getNomeAtividade();
				Date data = at.getData();
				Date data_fim = at.getData_fim();
				String descricao = at.getDescricao();
				String parceiro = at.getParceiro();
				String concelho =  at.getConcelho();
				int id_instituicao = at.getIdInstituicao();
				
				
				try {
					Class.forName(DRIVER);
					Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			        PreparedStatement st = con.prepareStatement(sql);
			        
			        st.setString(1, nome_atividade);
			        st.setDate(2, data);
			        st.setDate(3, data_fim);
			        st.setString(4, descricao);
			        st.setString(5, parceiro);
			        st.setString(6, concelho);
			        st.setInt(7, id_instituicao);
			        
			        resposta = st.executeUpdate();
			           
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				return resposta;	
			}			
}