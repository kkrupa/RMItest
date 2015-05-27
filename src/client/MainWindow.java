package client;

import java.rmi.RemoteException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

public class MainWindow {

	protected Shell shell;
	private Table table;
	private Text text;
	private String lista;
	private Klient klient;
	private String[] parts;
	TableItem item;

	public MainWindow(Klient klient) {
		this.klient = klient;
	}

	public void splitListaInTable(String listaProduktow, Table tabela) {
		table.removeAll();
		listaProduktow = listaProduktow.replace("[", "");
		listaProduktow = listaProduktow.replace("]", "");
		String[] lines = listaProduktow.split(",");
		for (String line : lines) {
			line = line.trim();
			item = new TableItem(tabela, SWT.NONE);
			parts = line.split("\\|");
			item.setText(parts);
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(703, 506);
		shell.setText("Sklep");

		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(34, 103, 537, 337);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setWidth(67);
		tblclmnId.setText("ID");

		TableColumn tblclmnNazwa = new TableColumn(table, SWT.NONE);
		tblclmnNazwa.setWidth(170);
		tblclmnNazwa.setText("Nazwa");

		TableColumn tblclmnMarka = new TableColumn(table, SWT.NONE);
		tblclmnMarka.setWidth(199);
		tblclmnMarka.setText("Marka");

		TableColumn tblclmnCena = new TableColumn(table, SWT.NONE);
		tblclmnCena.setWidth(100);
		tblclmnCena.setText("Cena");

		text = new Text(shell, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont(
				".Helvetica Neue DeskInterface", 16, SWT.NORMAL));
		text.setBounds(34, 54, 438, 43);

		Label lblSzybkieSzukanieMagazynu = new Label(shell, SWT.NONE);
		lblSzybkieSzukanieMagazynu.setFont(SWTResourceManager.getFont(
				".Helvetica Neue DeskInterface", 16, SWT.NORMAL));
		lblSzybkieSzukanieMagazynu.setBounds(34, 10, 420, 19);
		lblSzybkieSzukanieMagazynu.setText("Ekran wyszukiwania produktów");

		Label lblWpiszSzukanaFraz = new Label(shell, SWT.NONE);
		lblWpiszSzukanaFraz.setBounds(34, 34, 122, 14);
		lblWpiszSzukanaFraz.setText("Wpisz szukana frazę:");

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				String lancuch = text.getText().toString();
				try {
					if (text.getText().isEmpty()) {
						lista = klient.getListaProduktow();
					} else {
						lista = klient.szukajProduktu(lancuch);
					}
				} catch (RemoteException ex) {
					ex.printStackTrace();
				}
				splitListaInTable(lista, table);
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont(
				".Helvetica Neue DeskInterface", 14, SWT.NORMAL));
		btnNewButton.setBounds(478, 54, 95, 43);
		btnNewButton.setText("Szukaj");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont(".Helvetica Neue DeskInterface", 14, SWT.NORMAL));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (table.getSelectionCount() != 0) {
					try {
						int selectionIndex = table.getSelectionIndex();
						int id = Integer.parseInt((table.getItem(selectionIndex).getText(0)));
						if(klient.kupProdukt(id)) {
							System.out.println("Dziekujemy za zakupy!");
							splitListaInTable(klient.getListaProduktow(), table);
						}
						else System.out.println("Zakup nieudany. Ktoś mógł Cię ubiec :-(");
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBounds(587, 120, 95, 70);
		btnNewButton_1.setText("Kup \nprodukt");

	}
}
