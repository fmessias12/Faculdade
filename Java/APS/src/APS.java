import java.util.ArrayList;

import javax.swing.JOptionPane;

public class APS {
//Bubble
	static void Bubblesort(int[] vetor) {
		int n = vetor.length;
		int MenorNumero;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {

				if (vetor[j - 1] > vetor[j]) {

					MenorNumero = vetor[j - 1];
					vetor[j - 1] = vetor[j];
					vetor[j] = MenorNumero;
				}

			}
		}
	}

	public static int[] SelectSort(int[] Vetor) {

		for (int i = 0; i < Vetor.length - 1; i++) {
			int aux = i;
			for (int j = i + 1; j < Vetor.length; j++)
				if (Vetor[j] < Vetor[aux])
					aux = j;

			int MenorNumero = Vetor[aux];
			Vetor[aux] = Vetor[i];
			Vetor[i] = MenorNumero;
		}
		return Vetor;

	}

	// QuickSort e seus 2 métodos

	int dividir(int vetor[], int esq, int dir) {
		int i = esq, j = dir;
		int tmp;
		int pivot = vetor[(esq + dir) / 2];

		while (i <= j) {
			while (vetor[i] < pivot)
				i++;
			while (vetor[j] > pivot)
				j--;
			if (i <= j) {
				tmp = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = tmp;
				i++;
				j--;
			}

		}

		return i;
	}

	void quickSort(int vetor[], int esq, int dir) {
		int index = dividir(vetor, esq, dir);
		if (esq < index - 1) {
			quickSort(vetor, esq, index - 1);
		}

		if (index < dir) {
			quickSort(vetor, index, dir);
		}

	}

	public static void main(String[] args) {
				 String continuar="", opcao="";
				 int contador =0, i ,n;
				 long time = 0;
				 ArrayList vetororiginal = new ArrayList();
				 
				 
				 
				 do {
				 opcao =JOptionPane.showInputDialog("Digite 1 para escolher os números e 2 para usar números aleatórios");
				 
				 if (!opcao.equals("1") && !opcao.equals("2")) {
				 JOptionPane.showMessageDialog(null, "Opção inexistente, digite novamente");
				 }
				 } while (!opcao.equals("1") && !opcao.equals("2"));
				 
				 
				 
				 if (opcao.equals("1")) {
					 while (!continuar.equals("n")) {
						 vetororiginal.add(Integer.parseInt(JOptionPane.showInputDialog("Digite um número")));
						 contador++;
						 continuar = JOptionPane.showInputDialog("Continuar? Pressione qualquer tecla para sim ou N para nao");
						 
						 }
						 n = contador;
						 int vetorordenado[] = new int[n]; 
						 for (i = 0;i<n;i++) {
						 vetorordenado[i] = Integer.parseInt(vetororiginal.get(i).toString()); 
						 }
						 
						 
						 do {
						 opcao = JOptionPane.showInputDialog("Digite 1 para Bubble Sort, 2 para Selection Sort ou 3 para Quick Sort");
						 
						 if (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3")) {
						 JOptionPane.showMessageDialog(null, "Opção inexistente, digite novamente");
						 }
						 } while (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3"));if (opcao.equals("1")) {
							 Chronometer.start(); 
							 Bubblesort(vetorordenado);
							 Chronometer.stop(); 
							 time = Chronometer.elapsedTime(); 
							 
							 }
							 
							 else {
							 if (opcao.equals("2")) {
							 Chronometer.start(); 
							 SelectSort(vetorordenado);
							 Chronometer.stop(); 
							 time = Chronometer.elapsedTime(); 
							 }
							 
							 else {
							 APS ordenarQuick = new APS();
							 Chronometer.start();
							 ordenarQuick.quickSort(vetorordenado, 0, n-1);
							 Chronometer.stop();
							 time = Chronometer.elapsedTime(); 
							 }}
						 
						 System.out.println("v[i] = Original, Ordenado");
						 System.out.println("-------------------------");
						 for (i=0; i<vetororiginal.size(); i++) {
						 System.out.printf("v[%d] = %8s, %8d\n",i, vetororiginal.get(i).toString(),
						vetorordenado[i]);
						 }
						 
						 System.out.println("");
						 
						 System.out.println("Tempo de ordenação: " + time +"ms");
						 }
						 
						 //aleatorio
						 else {
						 
						 
						 n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de números aleatórios"));
						 int x;
						 int vetorordenado[]; 
						 vetorordenado = new int[n];
						 
						 for (i=0; i<n; i++) {x = (int)Math.round(Math.random()*n); //o resultado desta expressao sera um numero 
						 vetororiginal.add(x) ; // no intervalo de 0 ate 100
						 vetorordenado[i] = x;
						 }
						 
						 
						 
						 do {
						 opcao = JOptionPane.showInputDialog("Digite 1 para Bubble Sort, 2 para Selection Sort ou 3 para Quick Sort");
						 
						 if (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3")) {
						 JOptionPane.showMessageDialog(null, "Opção inexistente, digite novamente");
						 }
						 } while (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3"));
						 
						 
						 if (opcao.equals("1")) {
						 Chronometer.start(); 
						 Bubblesort(vetorordenado);
						 Chronometer.stop(); 
						 time = Chronometer.elapsedTime(); }
						 
						 else {
						 if (opcao.equals("2")) {
						 Chronometer.start(); 
						 SelectSort(vetorordenado);
						 Chronometer.stop(); 
						 time = Chronometer.elapsedTime();
						 }
						 
						 else {
						 APS ordenarQuick = new APS();
						 Chronometer.start(); 
						 ordenarQuick.quickSort(vetorordenado, 0, n-1);
						 Chronometer.stop();
						 time = Chronometer.elapsedTime();
						 }
						 }
						 
						 System.out.println("v[i] = Original, Ordenado");
						 System.out.println("-------------------------");
						 for (i=0; i<vetororiginal.size(); i++) {
						 System.out.printf("v[%d] = %8s, %8d\n",i, vetororiginal.get(i).toString(),
						vetorordenado[i]);
						 }
						 
						 
						 System.out.println("");
						 
						 System.out.println("Tempo de ordenação: " + time +"ms");
						 
						 }
						 
						 
						 }

}
