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
		
	}

	public void update(TelaCRUD tc) {
		
	}

	public void delete(TelaCRUD tc) {
		
	}

}
