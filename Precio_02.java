import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Precio_02 {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Precio_02 window = new Precio_02();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
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
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(53, 111, 125, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(227, 111, 125, 21);
		Label lblNewLabel = new Label(shell, SWT.NONE);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				int c = Integer.parseInt(text.getText());
				if (c!=0) {
					double p = Double.parseDouble(text_1.getText());
					String total = Double.toString(c*p);
					lblNewLabel.setText(total);
				}else {
					lblNewLabel.setText("ERROR EN LA COMPRA");
				}
			}
		});
		btnNewButton.setBounds(165, 149, 75, 25);
		btnNewButton.setText("Calcular");
		
		lblNewLabel.setBounds(130, 195, 140, 56);

	}
}
