package control;

import model.AlunoDAO;
import view.TelaCRUD;

public class CtrlTelaCRUD {

	public void select(TelaCRUD tc) {
		//Preenchendo o JavaBean
		int id = Integer.parseInt(tc.tfId.getText());
		Aluno al = new Aluno();
		al.setId(id);
		
		//Solicitando completar dados do JavaBean
		AlunoDAO ad = new AlunoDAO();
		ad.select(al);
		
		//a partir daqui colocar dados na tela
		tc.tfNome.setText(al.getNome());
		tc.tfRa.setText(al.getRa());
		tc.tfIdade.setText(Integer.toString(al.getIdade()));
	}

	public void insert(TelaCRUD tc) {
		//Preenchendo o JavaBean
		Aluno al = new Aluno();
		al.setId(Integer.parseInt(tc.tfId.getText()));
		al.setNome(tc.tfNome.getText());
		al.setRa(tc.tfRa.getText());
		al.setIdade(Integer.parseInt(tc.tfIdade.getText()));
		
		//Solicitando inserir dados no BD
		AlunoDAO ad = new AlunoDAO();
		ad.insert(al);
	}

	public void update(TelaCRUD tc) {
		//Preenchendo o JavaBean
				Aluno al = new Aluno();
				al.setId(Integer.parseInt(tc.tfId.getText()));
				al.setNome(tc.tfNome.getText());
				al.setRa(tc.tfRa.getText());
				al.setIdade(Integer.parseInt(tc.tfIdade.getText()));
				
				//Solicitando alterar dados no BD
				AlunoDAO ad = new AlunoDAO();
				ad.update(al);
	}

	public void delete(TelaCRUD tc) {
		//Preenchendo o JavaBean
				Aluno al = new Aluno();
				al.setId(Integer.parseInt(tc.tfId.getText()));

				
				//Solicitando excluir dado no BD
				AlunoDAO ad = new AlunoDAO();
				ad.delete(al);
	}

}
