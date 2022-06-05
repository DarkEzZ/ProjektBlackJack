import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class Igrica_Display extends Dobijene_karte {

	private JFrame frame;
	static int hit = 0;
	static int pohrana_2_diler = 0;
	static int pohrana_2_diler_simbol = 0;
	static int d = 0;// poziicja u nizu Jlabela
	static int de = 0;// poziicja u nizu Jlabela
	static int z = 0;// provjera kolika je suma korisnikovih karata
	static int m = 0;// provjera da li smo stisnuli stay
	static boolean f = false; // play boolean
	static boolean a = false; // uslov za pokretanje igre (mora betovat novac)
	static boolean c = true;// uslov pod kojim se aktivira stay mora bit broj manji od 21
	boolean stay = false;// uslov za pokretanje hit nakon stay
	static boolean zelim_dilera = false;
	JLabel Vrijednost_karte = new JLabel("");
	JLabel lblVrijednost_dilerovih_karti = new JLabel("");
	JLabel lbl1diler = new JLabel("");

	JLabel lbl2diler = new JLabel("");

	JLabel lbl3diler = new JLabel("");

	JLabel lbl4diler = new JLabel("");
	private JTextField textupis_novca;

	/**
	 * Launch the application.
	 */
	public static void pocetak() {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Igrica_Display window = new Igrica_Display();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Igrica_Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 102, 0));
		frame.setBounds(100, 100, 1227, 767);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Vrijednost_karte = new JLabel("");
		Vrijednost_karte.setFont(new Font("Poor Richard", Font.BOLD, 25));
		Vrijednost_karte.setHorizontalAlignment(SwingConstants.LEFT);
		Vrijednost_karte.setForeground(new Color(0, 0, 0));
		Vrijednost_karte.setBackground(new Color(0, 0, 0));
		Vrijednost_karte.setBounds(120, 567, 52, 56);
		frame.getContentPane().add(Vrijednost_karte);

		String sum2 = String.valueOf(Korisnik_funkcije.kolicina_novca_Korisnik);

		final JLabel lblispis_stanja = new JLabel("");
		lblispis_stanja.setForeground(Color.WHITE);
		lblispis_stanja.setBackground(Color.BLACK);
		lblispis_stanja.setHorizontalAlignment(SwingConstants.CENTER);
		lblispis_stanja.setFont(new Font("Sylfaen", Font.BOLD, 26));
		lblispis_stanja.setBounds(1024, 449, 147, 46);
		frame.getContentPane().add(lblispis_stanja);
		final JLabel lblKolicina_novca = new JLabel(sum2);
		lblKolicina_novca.setForeground(Color.WHITE);
		lblKolicina_novca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKolicina_novca.setFont(new Font("Sylfaen", Font.BOLD, 25));
		lblKolicina_novca.setBounds(1135, 10, 36, 41);
		frame.getContentPane().add(lblKolicina_novca);

		lblVrijednost_dilerovih_karti = new JLabel("");
		lblVrijednost_dilerovih_karti.setForeground(Color.BLACK);
		lblVrijednost_dilerovih_karti.setFont(new Font("Poor Richard", Font.BOLD, 25));
		lblVrijednost_dilerovih_karti.setHorizontalAlignment(SwingConstants.LEFT);
		lblVrijednost_dilerovih_karti.setBounds(169, 259, 52, 39);
		frame.getContentPane().add(lblVrijednost_dilerovih_karti);

		lbl1diler = new JLabel("");
		lbl1diler.setBounds(52, 34, 169, 214);
		frame.getContentPane().add(lbl1diler);

		lbl2diler = new JLabel("");
		lbl2diler.setBackground(new Color(0, 100, 0));
		lbl2diler.setBounds(231, 35, 162, 213);
		frame.getContentPane().add(lbl2diler);

		lbl3diler = new JLabel("");
		lbl3diler.setBounds(403, 34, 162, 214);
		frame.getContentPane().add(lbl3diler);
		final JLabel lbl5_karta = new JLabel("");
		lbl5_karta.setBounds(748, 343, 162, 213);
		frame.getContentPane().add(lbl5_karta);

		final JLabel lbl5_diler = new JLabel("");
		lbl5_diler.setBounds(748, 34, 162, 214);
		frame.getContentPane().add(lbl5_diler);
		lbl4diler = new JLabel("");
		lbl4diler.setBounds(576, 34, 162, 214);
		frame.getContentPane().add(lbl4diler);
		final JLabel lbl1karta = new JLabel("");
		lbl1karta.setBounds(52, 342, 162, 214);
		frame.getContentPane().add(lbl1karta);
		final JLabel diler_ispis[] = { lbl1diler, lbl2diler, lbl3diler, lbl4diler, lbl5_diler };
		final JLabel lbl2karta = new JLabel("");
		lbl2karta.setBounds(231, 342, 162, 214);
		frame.getContentPane().add(lbl2karta);
		final JLabel lblpobjeda_poraz = new JLabel("");
		lblpobjeda_poraz.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblpobjeda_poraz.setBounds(721, 16, 228, 31);
		frame.getContentPane().add(lblpobjeda_poraz);
		final JLabel lbl3_karta = new JLabel("");
		lbl3_karta.setBounds(403, 342, 162, 214);
		frame.getContentPane().add(lbl3_karta);
		final JButton btnHIT = new JButton("HIT");
		btnHIT.setFocusPainted(false);
		btnHIT.setBorderPainted(false);
		btnHIT.setFont(new Font("Sylfaen", Font.BOLD, 22));
		btnHIT.hide();
		final JLabel lbl4_karta = new JLabel("");
		lbl4_karta.setBounds(576, 342, 162, 214);
		frame.getContentPane().add(lbl4_karta);
		final JLabel korisnik_ispis[] = { lbl1karta, lbl2karta, lbl3_karta, lbl4_karta, lbl5_karta };

		btnHIT.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					if (c == false || stay == true || Korisnik_funkcije.brojac_karti >= 5) {

						throw new InputMismatchException();
					} else if (c == true && stay != true && f == true && Korisnik_funkcije.brojac_karti < 5) {
						Korisnik_funkcije.random_karte();
						hit++;
						ImageIcon karta = dobijena_karta(Korisnik_funkcije.broj_karte, Korisnik_funkcije.simbol_karte);
						karta = Omjer_img.oblikovanje_imgIcon(lbl1karta.getWidth(), lbl1karta.getHeight(),
								Image.SCALE_SMOOTH, karta);
						korisnik_ispis[d].setIcon(karta);
						d++;
						String suma = String.valueOf(Korisnik_funkcije.velicina_karti_korisnik);
						Vrijednost_karte.setText(suma);
						z = Korisnik_funkcije.hit();
						if (z == 1 || z == 2 || Korisnik_funkcije.brojac_karti == 5) {

							c = false;
							Win_draw_lose.pretvorba2(Korisnik_funkcije.velicina_karti_korisnik);
							Vrijednost_karte.setText(Win_draw_lose.potreban3);
							if (z == 1) {
								String stanje = Win_draw_lose.stanje();
								lblispis_stanja.setText(stanje);
								String sum2 = String.valueOf(Korisnik_funkcije.kolicina_novca_Korisnik);

								lblKolicina_novca.setText(sum2);
							}

							else if (z == 2) {

								ImageIcon karta2 = dobijena_karta(pohrana_2_diler, pohrana_2_diler_simbol);
								karta2 = Omjer_img.oblikovanje_imgIcon(lbl2diler.getWidth(), lbl2diler.getHeight(),
										Image.SCALE_SMOOTH, karta2);
								diler_ispis[1].setIcon(karta2);

								while (Diler_funkcije.velicina_karti_diler < 17 && Diler_funkcije.brojac_karti < 5) {
									Diler_funkcije.random_karte_diler();
									karta2 = dobijena_karta(Diler_funkcije.broj_karte, Diler_funkcije.simbol_karte);
									karta2 = Omjer_img.oblikovanje_imgIcon(lbl2diler.getWidth(), lbl2diler.getHeight(),
											Image.SCALE_SMOOTH, karta2);
									diler_ispis[de].setIcon(karta2);
									de++;

									if (de == 5) {
										de = 0;
									}
								}
								String suma2 = String.valueOf(Diler_funkcije.velicina_karti_diler);
								lblVrijednost_dilerovih_karti.setText(suma2);

								Win_draw_lose.pretvorba2(Diler_funkcije.velicina_karti_diler);
								lblVrijednost_dilerovih_karti.setText(Win_draw_lose.potreban3);
						
								String sum2 = String.valueOf(Korisnik_funkcije.kolicina_novca_Korisnik);

								lblKolicina_novca.setText(sum2);
								m = 0;

							}else if (Korisnik_funkcije.brojac_karti==5) {
		String stanje7 = Win_draw_lose.stanje();
								lblispis_stanja.setText(stanje7);
								ImageIcon karta2 = dobijena_karta(pohrana_2_diler, pohrana_2_diler_simbol);
								karta2 = Omjer_img.oblikovanje_imgIcon(lbl2diler.getWidth(), lbl2diler.getHeight(),
										Image.SCALE_SMOOTH, karta2);
								diler_ispis[1].setIcon(karta2);

								while (Diler_funkcije.velicina_karti_diler < 17 && Diler_funkcije.brojac_karti < 5) {
									Diler_funkcije.random_karte_diler();
									karta2 = dobijena_karta(Diler_funkcije.broj_karte, Diler_funkcije.simbol_karte);
									karta2 = Omjer_img.oblikovanje_imgIcon(lbl2diler.getWidth(), lbl2diler.getHeight(),
											Image.SCALE_SMOOTH, karta2);
									diler_ispis[de].setIcon(karta2);
									de++;

									if (de == 5) {
										de = 0;
									}
								}
								String suma2 = String.valueOf(Diler_funkcije.velicina_karti_diler);
								lblVrijednost_dilerovih_karti.setText(suma2);

								Win_draw_lose.pretvorba2(Diler_funkcije.velicina_karti_diler);
								lblVrijednost_dilerovih_karti.setText(Win_draw_lose.potreban3);
								String stanje = Win_draw_lose.stanje();
								lblispis_stanja.setText(stanje);
								String sum2 = String.valueOf(Korisnik_funkcije.kolicina_novca_Korisnik);

								lblKolicina_novca.setText(sum2);
								m = 0;

							}

							System.out.println(z);

						}
						if (d == 5) {
							d = 0;
						}
					}

				}

				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Ne mozete vise vuci karte");
				}

			}
		});

		btnHIT.setHorizontalAlignment(SwingConstants.CENTER);
		btnHIT.setBackground(Color.BLACK);
		btnHIT.setForeground(Color.WHITE);
		btnHIT.setBounds(967, 217, 120, 31);
		frame.getContentPane().add(btnHIT);

		JLabel lblNewLabel_1 = new JLabel("YOU:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Poor Richard", Font.BOLD, 25));
		lblNewLabel_1.setBounds(52, 567, 63, 56);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("DEALER:");
		lblNewLabel_3.setForeground(new Color(204, 0, 0));
		lblNewLabel_3.setFont(new Font("Poor Richard", Font.BOLD, 25));
		lblNewLabel_3.setBounds(52, 259, 120, 39);
		frame.getContentPane().add(lblNewLabel_3);

		final JButton btnStay = new JButton("STAY");
		btnStay.setFocusPainted(false);
		btnStay.setBorderPainted(false);
		btnStay.setForeground(Color.WHITE);
		btnStay.setFont(new Font("Sylfaen", Font.BOLD, 22));

		btnStay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (c == true && m == 0 && f == true) {
						stay = true;
						zelim_dilera = true;
						Win_draw_lose.pretvorba2(Korisnik_funkcije.velicina_karti_korisnik);
						Vrijednost_karte.setText(Win_draw_lose.potreban3);
						System.out.println("Vas iznos je pohranjen ");

						ImageIcon karta2 = dobijena_karta(pohrana_2_diler, pohrana_2_diler_simbol);
						karta2 = Omjer_img.oblikovanje_imgIcon(lbl2diler.getWidth(), lbl2diler.getHeight(),
								Image.SCALE_SMOOTH, karta2);
						diler_ispis[1].setIcon(karta2);

						while (Diler_funkcije.velicina_karti_diler < 17 && Diler_funkcije.brojac_karti < 5) {
							Diler_funkcije.random_karte_diler();
							System.out.println("Ukupna velicina dilera " + Diler_funkcije.velicina_karti_diler);
							karta2 = dobijena_karta(Diler_funkcije.broj_karte, Diler_funkcije.simbol_karte);
							karta2 = Omjer_img.oblikovanje_imgIcon(lbl2diler.getWidth(), lbl2diler.getHeight(),
									Image.SCALE_SMOOTH, karta2);
							diler_ispis[de].setIcon(karta2);
							de++;
							if (de == 5) {
								de = 0;
							}
						}
						String suma2 = String.valueOf(Diler_funkcije.velicina_karti_diler);
						lblVrijednost_dilerovih_karti.setText(suma2);
						System.out.println("Ukupna velicina dilera " + Diler_funkcije.velicina_karti_diler);
						Win_draw_lose.pretvorba2(Diler_funkcije.velicina_karti_diler);
						lblVrijednost_dilerovih_karti.setText(Win_draw_lose.potreban3);
						System.out.println("Ukupna velicina dilera " + Diler_funkcije.velicina_karti_diler);
						String stanje = Win_draw_lose.stanje();
						lblispis_stanja.setText(stanje);

						String sum = String.valueOf(Korisnik_funkcije.kolicina_novca_Korisnik);

						lblKolicina_novca.setText(sum);

						m++;

					}

					else if (m > 0) {
						JOptionPane.showMessageDialog(null, "Vec ste stisnuli");
						throw new InputMismatchException();

					} else if (c == false) {
						JOptionPane.showMessageDialog(null, "Partija je zavrsila");
						throw new InputMismatchException();

					}
				} catch (Exception e2) {

				}

			}
		});
		btnStay.setBackground(Color.BLACK);
		btnStay.setBounds(967, 283, 120, 31);
		btnStay.hide();
		frame.getContentPane().add(btnStay);

		JLabel lblNewLabel_4 = new JLabel("BET:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblNewLabel_4.setBounds(1013, 51, 42, 31);
		frame.getContentPane().add(lblNewLabel_4);

		textupis_novca = new JTextField();
		textupis_novca.setBounds(1085, 53, 86, 20);
		frame.getContentPane().add(textupis_novca);
		textupis_novca.setColumns(10);

		final JButton btnPLay = new JButton("PLAY");
		btnPLay.setFocusPainted(false);
		btnPLay.setBorderPainted(false);
		btnPLay.setForeground(Color.WHITE);
		btnPLay.setFont(new Font("Sylfaen", Font.BOLD, 16));
		btnPLay.setBackground(Color.BLACK);
		btnPLay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					int suma5 = Integer.parseInt(textupis_novca.getText());// dobijamo input korisnika

					a = Korisnik_funkcije.betovanje(suma5);

					

				String sum2 = String.valueOf(Korisnik_funkcije.kolicina_novca_Korisnik);

				lblKolicina_novca.setText(sum2);

				if (a == true) {

					btnPLay.hide();
					btnHIT.show();
					btnStay.show();

					Korisnik_funkcije.random_karte();
					ImageIcon karta = dobijena_karta(Korisnik_funkcije.broj_karte, Korisnik_funkcije.simbol_karte);
					karta = Omjer_img.oblikovanje_imgIcon(lbl1karta.getWidth(), lbl1karta.getHeight(),
							Image.SCALE_SMOOTH, karta);
					korisnik_ispis[d].setIcon(karta);
					d++;
					String suma = String.valueOf(Korisnik_funkcije.velicina_karti_korisnik);
					Vrijednost_karte.setText(suma);
					Korisnik_funkcije.random_karte();
					karta = dobijena_karta(Korisnik_funkcije.broj_karte, Korisnik_funkcije.simbol_karte);
					karta = Omjer_img.oblikovanje_imgIcon(lbl1karta.getWidth(), lbl1karta.getHeight(),
							Image.SCALE_SMOOTH, karta);
					korisnik_ispis[d].setIcon(karta);
					d++;
					String suma3 = String.valueOf(Korisnik_funkcije.velicina_karti_korisnik);
					Vrijednost_karte.setText(suma3);

					Diler_funkcije.random_karte_diler();

					ImageIcon karta2 = dobijena_karta(Diler_funkcije.broj_karte, Diler_funkcije.simbol_karte);
					karta2 = Omjer_img.oblikovanje_imgIcon(lbl2diler.getWidth(), lbl2diler.getHeight(),
							Image.SCALE_SMOOTH, karta2);
					diler_ispis[de].setIcon(karta2);
					de++;
					String suma2 = String.valueOf(Diler_funkcije.velicina_karti_diler);
					lblVrijednost_dilerovih_karti.setText(suma2);
					Diler_funkcije.random_karte_diler();
					pohrana_2_diler = Diler_funkcije.broj_karte;
					pohrana_2_diler_simbol = Diler_funkcije.simbol_karte;
					karta2 = okrenuta;
					karta2 = Omjer_img.oblikovanje_imgIcon(lbl2diler.getWidth(), lbl2diler.getHeight(),
							Image.SCALE_SMOOTH, karta2);
					diler_ispis[de].setIcon(karta2);
					de++;
					f = true;
				}

			}
		});
		btnPLay.setBounds(1085, 108, 86, 31);
		frame.getContentPane().add(btnPLay);
		final JButton btnAgain = new JButton("PLAY AGAIN");
		btnAgain.setFocusPainted(false);
		btnAgain.setBorderPainted(false);

		btnAgain.setForeground(Color.WHITE);
		btnAgain.setBackground(Color.BLACK);
		btnAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Korisnik_funkcije.brojac_karti = 0;
				Diler_funkcije.brojac_karti = 0;
				System.out.println(Korisnik_funkcije.brojac_karti);
				lbl1karta.setIcon(null);
				lbl2karta.setIcon(null);
				lbl3_karta.setIcon(null);
				lbl4_karta.setIcon(null);
				lbl5_karta.setIcon(null);
				lbl1diler.setIcon(null);
				lbl2diler.setIcon(null);
				lbl3diler.setIcon(null);
				lbl4diler.setIcon(null);
				lbl5_diler.setIcon(null);
				Korisnik_funkcije.reset();
				Diler_funkcije.reset();

				Win_draw_lose.z = false;
				Korisnik_funkcije.velicina_karti_korisnik = 0;
				Diler_funkcije.velicina_karti_diler = 0;
				d = 0;// poziicja u nizu Jlabela
				de = 0;// poziicja u nizu Jlabela
				z = 0;// provjera kolika je suma korisnikovih karata
				m = 0;// provjera da li smo stisnuli stay
				f = false; // play boolean
				a = false; // uslov za pokretanje igre (mora betovat novac)
				c = true;// uslov pod kojim se aktivira stay mora bit broj manji od 21
				stay = false;// uslov za pokretanje hit nakon stay
				zelim_dilera = false;
				pohrana_2_diler = 0;
				pohrana_2_diler_simbol = 0;
				btnHIT.hide();
				btnStay.hide();
				btnPLay.show();
				lblispis_stanja.setText(null);
				lblVrijednost_dilerovih_karti.setText(null);
				Vrijednost_karte.setText(null);
			}
		});
		btnAgain.setFont(new Font("Sylfaen", Font.BOLD, 18));
		btnAgain.setBounds(1002, 643, 169, 46);
		frame.getContentPane().add(btnAgain);

		JLabel lblNewLabel = new JLabel("YOUR MONEY :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblNewLabel.setBounds(967, 16, 147, 31);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(576, 657, -214, 41);
		frame.getContentPane().add(lblNewLabel_2);
		JLabel lblNewLabel_5 = new JLabel("");

		lblNewLabel_5.setBounds(947, 0, 264, 728);

		ImageIcon slika12 = crno;

		crno = Omjer_img.oblikovanje_imgIcon(lblNewLabel_5.getWidth(), lblNewLabel_5.getHeight(), Image.SCALE_SMOOTH,
				slika12);
		lblNewLabel_5.setIcon(slika12);
		frame.getContentPane().add(lblNewLabel_5);

	}
}
