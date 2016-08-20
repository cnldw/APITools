package com.itlaborer.ui;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.itlaborer.res.Resource;
import com.itlaborer.utils.ApiUtils;

/**
 * 
 * 关于界面
 * 
 * @author liu
 *
 */
public class AboutTools extends Dialog {

	private static Logger logger = Logger.getLogger(AboutTools.class.getName());
	protected Object result;
	protected Shell aboutToolsShell;

	public AboutTools(Shell parent, int style) {
		super(parent, style);
		setText("关于此工具");
		logger.info("进入关于");
	}

	public Object open() {
		createContents();
		aboutToolsShell.open();
		aboutToolsShell.layout();
		Display display = getParent().getDisplay();

		while (!aboutToolsShell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	private void createContents() {
		aboutToolsShell = new Shell(getParent(), getStyle());
		aboutToolsShell.setImage(SWTResourceManager.getImage(AboutTools.class, "/com/itlaborer/res/icon.ico"));
		aboutToolsShell.setSize(400, 218);
		aboutToolsShell.setText(getText());
		ApiUtils.SetCenterinParent(getParent(), aboutToolsShell);

		Label copyRightlabel = new Label(aboutToolsShell, SWT.CENTER);
		copyRightlabel.setBounds(10, 132, 375, 17);
		copyRightlabel.setText(Resource.getAUTHOR());

		Link link = new Link(aboutToolsShell, SWT.NONE);
		link.setBounds(143, 157, 108, 17);
		link.setText("<a>www.itlaborer.com</a>");
		link.addSelectionListener(new LinkSelection());

		Label versionLabel = new Label(aboutToolsShell, SWT.NONE);
		versionLabel.setBounds(184, 109, 25, 17);
		versionLabel.setText(Resource.getVersion());

		Label readMeTextLabel = new Label(aboutToolsShell, SWT.WRAP);
		readMeTextLabel.setBounds(10, 20, 375, 82);
		readMeTextLabel
				.setText(Resource.getEXPLAIN());
	}

	// 打开网站
	private final class LinkSelection extends SelectionAdapter {
		public void widgetSelected(SelectionEvent e) {
			logger.info("访问作者的博客");
			Program.launch(Resource.getBLOG());
		}
	}
}
