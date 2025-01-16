package UI;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import Entity.HocSinh;
import Entity.MonHoc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class statisticalUI extends JFrame {
	
	private DefaultCategoryDataset barData;
	private DefaultPieDataset pieData;
	private ChartPanel barPanel,piePanel;
	private JButton ScoreBut, CombBut;
	public statisticalUI() {
		super("Statistical");
		setSize(910,500);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		des();
		addListener();
		setVisible(true);
	}
	
	public void des(){
		
		barData = new DefaultCategoryDataset();
		JFreeChart bar = ChartFactory.createBarChart("Average score","Subject","Score", barData);
		barPanel = new ChartPanel(bar);
		barPanel.setBounds(0,0,785,460);
		
		pieData = new DefaultPieDataset();
		JFreeChart pie = ChartFactory.createPieChart("Combination", pieData, true, true, false);
		piePanel = new ChartPanel(pie);
		piePanel.setBounds(0,0,785,460);
		
		ScoreBut = new JButton("Avg Score");
		ScoreBut.setBounds(790,100,100,30);
		
		CombBut = new JButton("Comb");
		CombBut.setBounds(790,140,100,30);
		
		barPanel.setVisible(true);
		piePanel.setVisible(false);
		
		
		
		add(ScoreBut);
		add(CombBut);
		add(barPanel);
		add(piePanel);
	}
	
	public void updateData(ArrayList<HocSinh> DS) {
		double Avg_math = 0,
				Avg_lit = 0,
				Avg_eng = 0,
				Avg_phys = 0,
				Avg_chem = 0,
				Avg_bio = 0,
				Avg_hist = 0,
				Avg_geo = 0,
				Avg_civ = 0;
		
		if (DS != null) {
			Avg_math = Avg_Subject(DS,"toan");
			Avg_lit = Avg_Subject(DS,"van");
			Avg_eng = Avg_Subject(DS,"anh");
			Avg_phys = Avg_Subject(DS,"ly");
			Avg_chem = Avg_Subject(DS,"hoa");
			Avg_bio = Avg_Subject(DS,"sinh");
			Avg_hist = Avg_Subject(DS,"su");
			Avg_geo = Avg_Subject(DS,"dia");
			Avg_civ = Avg_Subject(DS,"gdcd");
		}
		barData.setValue(Avg_math,"Math","");
		barData.setValue(Avg_lit,"Lit","");
		barData.setValue(Avg_eng,"Eng","");
		barData.setValue(Avg_phys,"Phys","");
		barData.setValue(Avg_chem,"Chem","");
		barData.setValue(Avg_bio,"Bio","");
		barData.setValue(Avg_hist,"Hist","");
		barData.setValue(Avg_geo,"Geo","");
		barData.setValue(Avg_civ,"Civ","");
		
		double percen = Combination_Percen(DS);
		
		pieData.setValue("Natural Comb", percen);
		pieData.setValue("Social Comb", 100-percen);		
	}
	
	private double Avg_Subject(ArrayList<HocSinh> DS, String SubjectId) {
		double Sum = 0;
		int numbers = 0;
		for (HocSinh hs : DS) {
			for (MonHoc mh : hs.getTohop().getDSMon()) {
				if (mh.getMon_id().equals(SubjectId)) {
					Sum+=mh.getDiem();
					numbers++;
				}
			}
		}
		return (numbers == 0)?0:(Sum/numbers);
	}
	
	private double Combination_Percen(ArrayList<HocSinh> DS) {
		int numbers = 0;
		for (HocSinh hs : DS) {
			if (hs.getTohop().getId().equals("TN")) numbers++;
		}
		return ( (double) numbers/DS.size())*100;
	}
	
	private void addListener() {
		ScoreBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				barPanel.setVisible(true);
				piePanel.setVisible(false);
			}
		});
		
		CombBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				barPanel.setVisible(false);
				piePanel.setVisible(true);
			}
		});
	}
	
}
