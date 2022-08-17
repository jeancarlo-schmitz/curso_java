package main.java.br.com.strolker.campo.minado.modules.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.br.com.strolker.campo.minado.modules.domain.Campo;
import main.java.br.com.strolker.campo.minado.modules.domain.Tabuleiro;
import main.java.br.com.strolker.campo.minado.modules.exception.ExplosaoException;
import main.java.br.com.strolker.campo.minado.modules.exception.SairException;
import main.java.br.com.strolker.campo.minado.modules.service.CampoService;
import main.java.br.com.strolker.campo.minado.modules.service.TabuleiroService;
import main.java.br.com.strolker.campo.minado.modules.service.utils.TabuleiroConsoleUtils;

public class TabuleiroConsole {

	private Tabuleiro tabuleiro;
	
	private TabuleiroService tabuleiroService = new TabuleiroService();
	
	private CampoService campoService = new CampoService();
	
	private TabuleiroConsoleUtils utils = new TabuleiroConsoleUtils();
	
	private Scanner scanner = new Scanner(System.in);
	
	private int qtdMinas;
	private final List<Campo> tabuleiroCampos;

	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.tabuleiroCampos = tabuleiro.getCampos();
		this.qtdMinas = tabuleiro.getQtdMinas();
		
		executarJogo();
	}

	private void executarJogo() {
		try {
			
			boolean continuar = true;
			
			while(continuar) {
				
				cicloDoJogo();
				System.out.println("Iniciar Partida (S/n)");
				String iniciarPartida = scanner.nextLine();
				
				if(iniciarPartida.equalsIgnoreCase("n")) {
					continuar = false;
				}else {
					tabuleiroService.reiniciarTabuleiro(qtdMinas, tabuleiroCampos);
				}
			}
		} catch (SairException e) {
			System.out.println("Até mais!!!");
		} finally {
			scanner.close();
		}
	}

	private void cicloDoJogo() {
		try {
			
			while(!tabuleiroService.isObjetivoJogoAlcancado(tabuleiroCampos)) {
				this.desenharTabuleiro();
				
				this.executaRegrasDoJogo();
				
			}
			this.desenharTabuleiro();
			System.out.println("Você Ganhou!");
		} catch (ExplosaoException e) {
			campoService.abrirTodosOsCamposMinados(tabuleiroCampos);
			this.desenharTabuleiro();
			System.out.println("Kabum!! Você Perdeu!");
		}
	}

	private void desenharTabuleiro() {
		System.out.println(tabuleiro.toString());
	}

	private void executaRegrasDoJogo() {
		boolean coordenadaCorreta = true;
		ArrayList<Integer> coordenadasDigitadas;
		do {
			String valorDigitado = utils.capturarValorDigitado("Digite a coordenada (x, y): ", scanner);
			coordenadasDigitadas = utils.extrairDadosDigitados(valorDigitado);
			if(utils.verificaCoordenadasDigitadasCorretas(coordenadasDigitadas, tabuleiro.getLinhas(), tabuleiro.getColunas())) {
				coordenadaCorreta = true;
				this.executaRegraDeAcordoComOpcaoEscolhida(coordenadasDigitadas);
			}else {
				coordenadaCorreta = false;
				System.out.println("Coordenadas Digitadas incorretamente, favor digite uma coordenada Valida");
			}
		} while(!coordenadaCorreta);
		
	}

	private void executaRegraDeAcordoComOpcaoEscolhida(ArrayList<Integer> coordenadasDigitadas) {
		boolean opcaoCorreta = true;
		int linha = coordenadasDigitadas.get(0);
		int coluna =  coordenadasDigitadas.get(1);
		do {
			String valorDigitado = utils.capturarValorDigitado("Digite: 1 - para abrir o Campo ou 2 para (Des)marcar o campo: ", scanner);
			if(utils.verificaOpcaoDigitadaCorretamente(valorDigitado)) {
				opcaoCorreta = true;
				int opcaoEscolhida = utils.getOpcaoDigitada(valorDigitado);
				if(opcaoEscolhida == 1) {
					campoService.abrirCampoSelecionado(linha, coluna, tabuleiroCampos);
				}else {
					campoService.marcarCampoSelecionado(linha, coluna, tabuleiroCampos);
				}
			}else {
				opcaoCorreta = false;
				System.out.println("Opção incorreta, escolha a opção Correta");
			}
		} while(!opcaoCorreta);
		
	}
}
