/*
  Dilarang keras menggandakan/mengcopy/menyebarkan/membajak/mendecompile 
  Software ini dalam bentuk apapun tanpa seijin pembuat software
  (Khanza.Soft Media). Bagi yang sengaja membajak softaware ini ta
  npa ijin, kami sumpahi sial 1000 turunan, miskin sampai 500 turu
  nan. Selalu mendapat kecelakaan sampai 400 turunan. Anak pertama
  nya cacat tidak punya kaki sampai 300 turunan. Susah cari jodoh
  sampai umur 50 tahun sampai 200 turunan. Ya Alloh maafkan kami 
  karena telah berdoa buruk, semua ini kami lakukan karena kami ti
  dak pernah rela karya kami dibajak tanpa ijin.
 */

package rekammedis;

import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import kepegawaian.DlgCariPegawai;


/**
 *
 * @author perpustakaan
 */
public final class RMTriaseIGDModif1 extends javax.swing.JDialog {
    private DefaultTableModel tabMode,tabModePemeriksaan,tabModeSkala1,tabModeSkala2,tabModeSkala3,tabModeSkala4,tabModeSkala5,tabModePemeriksaan2,TabModeAwal;
    private Connection koneksi=koneksiDB.condb();
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private PreparedStatement ps,ps2,ps3;
    private ResultSet rs,rs2,rs3;
    private int i=0,jml=0,index=0,jmlskala1=0,jmlskala2=0,jmlskala3=0,jmlskala4=0,jmlskala5=0;
    private MasterTriaseMacamKasus kasus=new MasterTriaseMacamKasus(null,false);
    private boolean[] pilih; 
    private String[] kode,pengkajian;
    private DlgCariPegawai pegawai=new DlgCariPegawai(null,false);
    private String keputusan="",pilihan="",datatriase="",finger="",param1,param2,param3,param4,getIsolasi,getPsikologi,kodepetugas="";
    private StringBuilder htmlContent;
    
    /** Creates new form DlgRujuk
     * @param parent
     * @param modal */
    public RMTriaseIGDModif1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        scrollPane15.setVisible(true);
        this.setLocation(8,1);
        tabMode=new DefaultTableModel(null,new Object[]{
                "No.Rawat","No.RM","Nama Pasien","Tgl.Kunjungan","Cara Masuk","Transportasi",
                "Alasan Kedatangan","Keterangan","Kode Kasus","Macam Kasus",
                "TD","Nadi","Pernafasan","Suhu","O2","Nyeri","Keluhan Utama","K Khusus","Catatan","ESI 1","ESI 2","ESI 3","ESI 4","ESI 5",
                "Cukup Bulan","Cairan Amnion","Pernafasan ","Tonus","Isolasi","Psikologi","Nyerii","Lokasi","Durasi","Frekuensi","Gam Nyeri"
            }){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbTriase.setModel(tabMode);

        //tbObat.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbObat.getBackground()));
        tbTriase.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbTriase.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 35; i++) {
            TableColumn column = tbTriase.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(105);
            }else if(i==1){
                column.setPreferredWidth(70);
            }else if(i==2){
                column.setPreferredWidth(160);
            }else if(i==3){
                column.setPreferredWidth(120);
            }else if(i==4){
                column.setPreferredWidth(80);
            }else if(i==5){
                column.setPreferredWidth(80);
            }else if(i==6){
                column.setPreferredWidth(110);
            }else if(i==7){
                column.setPreferredWidth(180);
            }else if(i==8){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==9){
                column.setPreferredWidth(100);
            }else if(i==10){
                column.setPreferredWidth(25);
            }else if(i==11){
                column.setPreferredWidth(30);
            }else if(i==12){
                column.setPreferredWidth(30);
            }else if(i==13){
                column.setPreferredWidth(30);
            }else if(i==14){
                column.setPreferredWidth(30);
            }else if(i==15){
                column.setPreferredWidth(100);
            }else if(i==16){
                column.setPreferredWidth(200);
            }else if(i==17){
                column.setPreferredWidth(30);
            }else if(i==18){
                column.setPreferredWidth(100);
            }else if(i==19){
                column.setPreferredWidth(100);
            }else if(i==20){
                column.setPreferredWidth(100);
            }else if(i==21){
                column.setPreferredWidth(100);
            }else if(i==22){
                column.setPreferredWidth(100);
            }else if(i==23){
                column.setPreferredWidth(100);
            }else if(i==24){
                column.setPreferredWidth(100);
            }else if(i==25){
                column.setPreferredWidth(100);
            }else if(i==26){
                column.setPreferredWidth(100);
            }else if(i==27){
                column.setPreferredWidth(50);
            }else if(i==28){
                column.setPreferredWidth(50);
            }else if(i==29){
                column.setPreferredWidth(50);
            }else if(i==30){
                column.setPreferredWidth(50);
            }else if(i==31){
                column.setPreferredWidth(50);
            }else if(i==32){
                column.setPreferredWidth(50);
            }else if(i==33){
                column.setPreferredWidth(50);
            }else if(i==34){
                column.setPreferredWidth(50);
            }else if(i==35){
                column.setPreferredWidth(50);
            }else if(i==36){
                column.setPreferredWidth(50);
            }else if(i==37){
                column.setPreferredWidth(50);
            }else if(i==38){
                column.setPreferredWidth(50);
            }else if(i==39){
                column.setPreferredWidth(50);
            }
        }
        tbTriase.setDefaultRenderer(Object.class, new WarnaTable());
        
        tabModePemeriksaan=new DefaultTableModel(null,new Object[]{
                "Kode Pemeriksaan","Pemeriksaan"
            }){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbPemeriksaan.setModel(tabModePemeriksaan);

        //tbObat.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbObat.getBackground()));
        tbPemeriksaan.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbPemeriksaan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 2; i++) {
            TableColumn column = tbPemeriksaan.getColumnModel().getColumn(i);
            if(i==0){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==1){
                column.setPreferredWidth(255);
            }
        }
        tbPemeriksaan.setDefaultRenderer(Object.class, new WarnaTable());
        
        tabModePemeriksaan2=new DefaultTableModel(null,new Object[]{
                "Kode Pemeriksaan","Pemeriksaan"
            }){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
//        tbPemeriksaan2.setModel(tabModePemeriksaan2);
//
//        //tbObat.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbObat.getBackground()));
//        tbPemeriksaan2.setPreferredScrollableViewportSize(new Dimension(500,500));
//        tbPemeriksaan2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//
//        for (i = 0; i < 2; i++) {
//            TableColumn column = tbPemeriksaan2.getColumnModel().getColumn(i);
//            if(i==0){
//                column.setMinWidth(0);
//                column.setMaxWidth(0);
//            }else if(i==1){
//                column.setPreferredWidth(255);
//            }
//        }
//        tbPemeriksaan2.setDefaultRenderer(Object.class, new WarnaTable());
        
        tabModeSkala1=new DefaultTableModel(null,new Object[]{
                "P","Kode","Immediate/Segera"
            }){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        
        
        tabModeSkala2=new DefaultTableModel(null,new Object[]{
                "P","Kode","Emergensi"
            }){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        
        tabModeSkala3=new DefaultTableModel(null,new Object[]{
                "P","Kode","Urgensi"
            }){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
//        tbSkala3.setModel(tabModeSkala3);
//
//        //tbObat.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbObat.getBackground()));
//        tbSkala3.setPreferredScrollableViewportSize(new Dimension(500,500));
//        tbSkala3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

//        for (i = 0; i < 3; i++) {
//            TableColumn column = tbSkala3.getColumnModel().getColumn(i);
//            if(i==0){
//                column.setPreferredWidth(20);
//            }else if(i==1){
//                column.setMinWidth(0);
//                column.setMaxWidth(0);
//            }else if(i==2){
//                column.setPreferredWidth(340);
//            }
//        }
//        tbSkala3.getTableHeader().setForeground(new Color(200,200,0));
//        tbSkala3.setDefaultRenderer(Object.class, new WarnaTable());
        
        tabModeSkala4=new DefaultTableModel(null,new Object[]{
                "P","Kode","Semi Urgensi/Urgensi Rendah"
            }){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
//        tbSkala4.setModel(tabModeSkala4);
//
//        //tbObat.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbObat.getBackground()));
//        tbSkala4.setPreferredScrollableViewportSize(new Dimension(500,500));
//        tbSkala4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        
//        for (i = 0; i < 3; i++) {
//            TableColumn column = tbSkala4.getColumnModel().getColumn(i);
//            if(i==0){
//                column.setPreferredWidth(20);
//            }else if(i==1){
//                column.setMinWidth(0);
//                column.setMaxWidth(0);
//            }else if(i==2){
//                column.setPreferredWidth(340);
//            }
//        }
//        tbSkala4.getTableHeader().setForeground(new Color(0,170,0));
//        tbSkala4.setDefaultRenderer(Object.class, new WarnaTable());
        
        tabModeSkala5=new DefaultTableModel(null,new Object[]{
                "P","Kode","Non Urgensi"
            }){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
//        tbSkala5.setModel(tabModeSkala5);
//
//        //tbObat.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbObat.getBackground()));
//        tbSkala5.setPreferredScrollableViewportSize(new Dimension(500,500));
//        tbSkala5.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//
//        for (i = 0; i < 3; i++) {
//            TableColumn column = tbSkala5.getColumnModel().getColumn(i);
//            if(i==0){
//                column.setPreferredWidth(20);
//            }else if(i==1){
//                column.setMinWidth(0);
//                column.setMaxWidth(0);
//            }else if(i==2){
//                column.setPreferredWidth(340);
//            }
//        }
//        tbSkala5.getTableHeader().setForeground(new Color(150,150,150));
//        tbSkala5.setDefaultRenderer(Object.class, new WarnaTable());
        
        TCari.setDocument(new batasInput((int)100).getKata(TCari));
        TCariPemeriksaan.setDocument(new batasInput((int)100).getKata(TCariPemeriksaan));
       
       
        
        KeteranganKedatangan.setDocument(new batasInput((int)100).getKata(KeteranganKedatangan));
        PrimerSuhu.setDocument(new batasInput((byte)5).getKata(PrimerSuhu));
       
        PrimerNyeri.setDocument(new batasInput((byte)5).getKata(PrimerNyeri));
       
        PrimerTensi.setDocument(new batasInput((byte)8).getKata(PrimerTensi));
        
        PrimerNadi.setDocument(new batasInput((byte)3).getKata(PrimerNadi));
       
        PrimerSaturasi.setDocument(new batasInput((byte)3).getKata(PrimerSaturasi));
      
        PrimerRespirasi.setDocument(new batasInput((byte)3).getKata(PrimerRespirasi));
        
        PrimerCatatan.setDocument(new batasInput((int)100).getKata(PrimerCatatan));
       
        PrimerKeluhanUtama.setDocument(new batasInput((int)400).getKata(PrimerKeluhanUtama));
       
        
        TabModeAwal=new DefaultTableModel(null,new Object[]{
            "No.Rawat","No.RM","Nama Pasien","Tgl.Lahir","J.K.","NIP","Nama Dokter","Tanggal","Anamnesis","Hubungan","Keluhan Utama","Riwayat Penyakit Sekarang","Riwayat Penyakit Dahulu",
            "Riwayat Penyakit Keluarga","Riwayat Penggunakan Obat","Riwayat Alergi","Keadaan Umum","GCS","Kesadaran","TD(mmHg)","Nadi(x/menit)","RR(x/menit)","Suhu","SpO2","BB(Kg)","TB(cm)","Kepala",
            "Mata","Gigi & Mulut","Leher","Thoraks","Abdomen","Genital & Anus","Ekstremitas","Ket.Pemeriksaan Fisik","Ket.Status Lokalis","EKG","Radiologi","Laborat","Diagnosis/Asesmen","Tatalaksana"
        }){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        
        tbAwalMedisIGD.setModel(TabModeAwal);
        tbAwalMedisIGD.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbAwalMedisIGD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 41; i++) {
            TableColumn column = tbAwalMedisIGD.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(105);
            }else if(i==1){
                column.setPreferredWidth(70);
            }else if(i==2){
                column.setPreferredWidth(150);
            }else if(i==3){
                column.setPreferredWidth(65);
            }else if(i==4){
                column.setPreferredWidth(55);
            }else if(i==5){
                column.setPreferredWidth(80);
            }else if(i==6){
                column.setPreferredWidth(150);
            }else if(i==7){
                column.setPreferredWidth(115);
            }else if(i==8){
                column.setPreferredWidth(80);
            }else if(i==9){
                column.setPreferredWidth(100);
            }else if(i==10){
                column.setPreferredWidth(300);
            }else if(i==11){
                column.setPreferredWidth(150);
            }else if(i==12){
                column.setPreferredWidth(150);
            }else if(i==13){
                column.setPreferredWidth(150);
            }else if(i==14){
                column.setPreferredWidth(150);
            }else if(i==15){
                column.setPreferredWidth(120);
            }else if(i==16){
                column.setPreferredWidth(90);
            }else if(i==17){
                column.setPreferredWidth(50);
            }else if(i==18){
                column.setPreferredWidth(80);
            }else if(i==19){
                column.setPreferredWidth(60);
            }else if(i==20){
                column.setPreferredWidth(75);
            }else if(i==21){
                column.setPreferredWidth(67);
            }else if(i==22){
                column.setPreferredWidth(40);
            }else if(i==23){
                column.setPreferredWidth(40);
            }else if(i==24){
                column.setPreferredWidth(40);
            }else if(i==25){
                column.setPreferredWidth(40);
            }else if(i==26){
                column.setPreferredWidth(80);
            }else if(i==27){
                column.setPreferredWidth(80);
            }else if(i==28){
                column.setPreferredWidth(80);
            }else if(i==29){
                column.setPreferredWidth(80);
            }else if(i==30){
                column.setPreferredWidth(80);
            }else if(i==31){
                column.setPreferredWidth(80);
            }else if(i==32){
                column.setPreferredWidth(80);
            }else if(i==33){
                column.setPreferredWidth(80);
            }else if(i==34){
                column.setPreferredWidth(300);
            }else if(i==35){
                column.setPreferredWidth(200);
            }else if(i==36){
                column.setPreferredWidth(170);
            }else if(i==37){
                column.setPreferredWidth(170);
            }else if(i==38){
                column.setPreferredWidth(170);
            }else if(i==39){
                column.setPreferredWidth(150);
            }else if(i==40){
                column.setPreferredWidth(300);
            }
        }
        tbAwalMedisIGD.setDefaultRenderer(Object.class, new WarnaTable());
        
        TNoRw.setDocument(new batasInput((byte)17).getKata(TNoRw));
        Hubungan.setDocument(new batasInput((int)30).getKata(Hubungan));
        KeluhanUtama.setDocument(new batasInput((int)2000).getKata(KeluhanUtama));
        RPS.setDocument(new batasInput((int)2000).getKata(RPS));
        RPK.setDocument(new batasInput((int)2000).getKata(RPK));
        RPD.setDocument(new batasInput((int)1000).getKata(RPD));
        RPO.setDocument(new batasInput((int)1000).getKata(RPO));
        Alergi.setDocument(new batasInput((int)50).getKata(Alergi));
        GCS.setDocument(new batasInput((byte)10).getKata(GCS));
        TD.setDocument(new batasInput((byte)8).getKata(TD));
        Nadi.setDocument(new batasInput((byte)5).getKata(Nadi));
        RR.setDocument(new batasInput((byte)5).getKata(RR));
        Suhu.setDocument(new batasInput((byte)5).getKata(Suhu));
        SPO.setDocument(new batasInput((byte)5).getKata(SPO));
        BB.setDocument(new batasInput((byte)5).getKata(BB));
        TB.setDocument(new batasInput((byte)5).getKata(TB));
        KetFisik.setDocument(new batasInput((int)5000).getKata(KetFisik));
        KetLokalis.setDocument(new batasInput((int)3000).getKata(KetLokalis));
        EKG.setDocument(new batasInput((int)3000).getKata(EKG));
        Diagnosis.setDocument(new batasInput((int)500).getKata(Diagnosis));
        Tatalaksana.setDocument(new batasInput((int)5000).getKata(Tatalaksana));
        TCari.setDocument(new batasInput((int)100).getKata(TCari));
        
       
        if(koneksiDB.CARICEPAT().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
            });
        }  
        
        kasus.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(kasus.getTable().getSelectedRow()!= -1){
                    KdKasus.setText(kasus.getTable().getValueAt(kasus.getTable().getSelectedRow(),0).toString());
                    NmKasus.setText(kasus.getTable().getValueAt(kasus.getTable().getSelectedRow(),1).toString());
                }  
                btnKasus.requestFocus();
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        
        kasus.getTable().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    kasus.dispose();
                }                
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
        pegawai.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(pegawai.getTable().getSelectedRow()!= -1){       
                    if(index==1){
                        PrimerKodePetugas.setText(pegawai.getTable().getValueAt(pegawai.getTable().getSelectedRow(),0).toString());
                        PrimerNamaPetugas.setText(pegawai.getTable().getValueAt(pegawai.getTable().getSelectedRow(),1).toString());
                        btnPrimerPetugas.requestFocus();
                    }//else if(index==2){
//                        SekunderKodePetugas.setText(pegawai.getTable().getValueAt(pegawai.getTable().getSelectedRow(),0).toString());
//                        SekunderNamaPetugas.setText(pegawai.getTable().getValueAt(pegawai.getTable().getSelectedRow(),1).toString());
//                        btnSekunderPetugas.requestFocus();
//                    }
                }   
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        
        HTMLEditorKit kit = new HTMLEditorKit();
        LoadHTML.setEditable(true);
        LoadHTML.setEditorKit(kit);
        LoadHTML2.setEditable(true);
        LoadHTML2.setEditorKit(kit);
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule(
                ".isi td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-bottom: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                ".isi2 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#323232;}"+
                ".isi3 td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                ".isi4 td{font: 11px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                ".isi5 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#AA0000;}"+
                ".isi6 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#FF0000;}"+
                ".isi7 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#C8C800;}"+
                ".isi8 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#00AA00;}"+
                ".isi9 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#969696;}"
        );
        
        Document doc = kit.createDefaultDocument();
        LoadHTML.setDocument(doc);
        LoadHTML2.setDocument(doc);
        
        ChkAccor.setSelected(false);
        isMenu();
       
        jScrollPane1.setVisible(false);
        prioritas1.setVisible(false);
        prioritas2.setVisible(false);
        prioritas3.setVisible(false);
        prioritas4.setVisible(false);
        cbPrioritas3tidak.setVisible(false);
        cbPrioritas3.setVisible(false);
        
        
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        LoadHTML2 = new widget.editorpane();
        groupnyeri = new javax.swing.ButtonGroup();
        cukupbulan = new javax.swing.ButtonGroup();
        cairanamnion = new javax.swing.ButtonGroup();
        pernafasan = new javax.swing.ButtonGroup();
        tonus = new javax.swing.ButtonGroup();
        internalFrame1 = new widget.InternalFrame();
        TabPilihan = new javax.swing.JTabbedPane();
        ScrollTriase = new widget.ScrollPane();
        FormTriase = new widget.InternalFrame();
        FormInput = new widget.PanelBiasa();
        jLabel4 = new widget.Label();
        TNoRw = new widget.TextBox();
        TPasien = new widget.TextBox();
        TNoRM = new widget.TextBox();
        jLabel18 = new widget.Label();
        TanggalKunjungan = new widget.Tanggal();
        jLabel20 = new widget.Label();
        CaraMasuk = new widget.ComboBox();
        jLabel22 = new widget.Label();
        Transportasi = new widget.ComboBox();
        jLabel23 = new widget.Label();
        AlasanKedatangan = new widget.ComboBox();
        jLabel5 = new widget.Label();
        KdKasus = new widget.TextBox();
        NmKasus = new widget.TextBox();
        btnKasus = new widget.Button();
        KeteranganKedatangan = new widget.TextBox();
        jLabel8 = new widget.Label();
        jLabel52 = new widget.Label();
        TglLahir = new widget.TextBox();
        jLabel55 = new widget.Label();
        Jk = new widget.TextBox();
        Hubungan = new widget.TextBox();
        Anamnesis = new widget.ComboBox();
        jLabel73 = new widget.Label();
        TabTriase = new javax.swing.JTabbedPane();
        scrollPane15 = new widget.ScrollPane();
        internalFrame5 = new widget.InternalFrame();
        internalFrame7 = new widget.InternalFrame();
        scrollPane1 = new widget.ScrollPane();
        PrimerKeluhanUtama = new widget.TextArea();
        jLabel9 = new widget.Label();
        jLabel24 = new widget.Label();
        PrimerKubutuhanKusus = new widget.ComboBox();
        jLabel10 = new widget.Label();
        PrimerSuhu = new widget.TextBox();
        jLabel16 = new widget.Label();
        PrimerSaturasi = new widget.TextBox();
        PrimerNadi = new widget.TextBox();
        jLabel26 = new widget.Label();
        PrimerRespirasi = new widget.TextBox();
        jLabel27 = new widget.Label();
        PrimerTensi = new widget.TextBox();
        jLabel11 = new widget.Label();
        internalFrame8 = new widget.InternalFrame();
        jLabel12 = new widget.Label();
        PrimerKodePetugas = new widget.TextBox();
        PrimerNamaPetugas = new widget.TextBox();
        btnPrimerPetugas = new widget.Button();
        jLabel28 = new widget.Label();
        PrimerTanggalTriase = new widget.Tanggal();
        jLabel29 = new widget.Label();
        PrimerResusitasi = new widget.RadioButton();
        PrimerKritis = new widget.RadioButton();
        label14 = new widget.Label();
        PrimerCatatan = new widget.TextBox();
        SekunderZonaKuning1 = new widget.RadioButton();
        SekunderZonaHijau1 = new widget.RadioButton();
        internalFrame3 = new widget.InternalFrame();
        internalFrame9 = new widget.InternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panelisi5 = new widget.panelisi();
        label10 = new widget.Label();
        TCariPemeriksaan = new widget.TextBox();
        BtnCariPemeriksaan = new widget.Button();
        BtnTambahPemeriksaan = new widget.Button();
        Scroll2 = new widget.ScrollPane();
        tbPemeriksaan = new widget.Table();
        internalFrame2 = new widget.InternalFrame();
        panelisi3 = new widget.panelisi();
        panelisi1 = new widget.panelisi();
        label1 = new widget.Label();
        panelisi2 = new widget.panelisi();
        label2 = new widget.Label();
        panelisi4 = new widget.panelisi();
        label3 = new widget.Label();
        cbPrioritas543 = new widget.ComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new widget.Table();
        panelisi10 = new widget.panelisi();
        cbPrioritas1 = new widget.CekBox();
        panelisi11 = new widget.panelisi();
        cbPrioritas2b = new widget.CekBox();
        cbPrioritas2a = new widget.CekBox();
        cbPrioritas2c = new widget.CekBox();
        panelisi16 = new widget.panelisi();
        label16 = new widget.Label();
        label19 = new widget.Label();
        label20 = new widget.Label();
        label21 = new widget.Label();
        frekuensinyeri = new widget.TextBox();
        lokasinyeri = new widget.TextBox();
        label22 = new widget.Label();
        durasinyeri = new widget.TextBox();
        label23 = new widget.Label();
        gambarannyeri = new widget.TextBox();
        comboBox1 = new widget.ComboBox();
        panelisi17 = new widget.panelisi();
        label24 = new widget.Label();
        panelisi18 = new widget.panelisi();
        PanelWall1 = new usu.widget.glass.PanelGlass();
        jLabel25 = new widget.Label();
        PrimerNyeri = new widget.TextBox();
        cbPrioritas3 = new widget.CekBox();
        cbPrioritas3tidak = new widget.CekBox();
        panelisi9 = new widget.panelisi();
        panelisi12 = new widget.panelisi();
        label4 = new widget.Label();
        label5 = new widget.Label();
        label6 = new widget.Label();
        label7 = new widget.Label();
        label8 = new widget.Label();
        cekTidak1 = new widget.RadioButton();
        cekYa1 = new widget.RadioButton();
        cekTidak2 = new widget.RadioButton();
        cekYa2 = new widget.RadioButton();
        cekTidak3 = new widget.RadioButton();
        cekYa3 = new widget.RadioButton();
        cekTidak4 = new widget.RadioButton();
        cekYa4 = new widget.RadioButton();
        panelisi13 = new widget.panelisi();
        panelisi14 = new widget.panelisi();
        label9 = new widget.Label();
        panelisi15 = new widget.panelisi();
        label17 = new widget.Label();
        cekBox5 = new widget.CekBox();
        cekBox6 = new widget.CekBox();
        cekBox7 = new widget.CekBox();
        cekBox8 = new widget.CekBox();
        label18 = new widget.Label();
        cekBox9 = new widget.CekBox();
        cekBox10 = new widget.CekBox();
        cekBox11 = new widget.CekBox();
        cekBox12 = new widget.CekBox();
        label25 = new widget.Label();
        prioritas2 = new widget.panelisi();
        label27 = new widget.Label();
        prioritas1 = new widget.panelisi();
        label26 = new widget.Label();
        prioritas4 = new widget.panelisi();
        label29 = new widget.Label();
        prioritas3 = new widget.panelisi();
        label28 = new widget.Label();
        scrollInput = new widget.ScrollPane();
        FormInput1 = new widget.PanelBiasa();
        jLabel53 = new widget.Label();
        jLabel56 = new widget.Label();
        BB = new widget.TextBox();
        jLabel57 = new widget.Label();
        TB = new widget.TextBox();
        jLabel58 = new widget.Label();
        jLabel59 = new widget.Label();
        Nadi = new widget.TextBox();
        jLabel60 = new widget.Label();
        jLabel61 = new widget.Label();
        Suhu = new widget.TextBox();
        jLabel62 = new widget.Label();
        TD = new widget.TextBox();
        jLabel63 = new widget.Label();
        jLabel64 = new widget.Label();
        jLabel65 = new widget.Label();
        jLabel66 = new widget.Label();
        RR = new widget.TextBox();
        jLabel67 = new widget.Label();
        jLabel68 = new widget.Label();
        Alergi = new widget.TextBox();
        scrollPane6 = new widget.ScrollPane();
        KeluhanUtama = new widget.TextArea();
        jLabel69 = new widget.Label();
        scrollPane13 = new widget.ScrollPane();
        RPD = new widget.TextArea();
        jLabel70 = new widget.Label();
        scrollPane3 = new widget.ScrollPane();
        RPK = new widget.TextArea();
        jLabel71 = new widget.Label();
        scrollPane4 = new widget.ScrollPane();
        RPO = new widget.TextArea();
        scrollPane5 = new widget.ScrollPane();
        KetFisik = new widget.TextArea();
        jLabel72 = new widget.Label();
        GCS = new widget.TextBox();
        jLabel94 = new widget.Label();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel74 = new widget.Label();
        scrollPane7 = new widget.ScrollPane();
        RPS = new widget.TextArea();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel39 = new widget.Label();
        Keadaan = new widget.ComboBox();
        jLabel40 = new widget.Label();
        Kesadaran = new widget.ComboBox();
        jLabel41 = new widget.Label();
        jLabel75 = new widget.Label();
        SPO = new widget.TextBox();
        jLabel35 = new widget.Label();
        Kepala = new widget.ComboBox();
        jLabel44 = new widget.Label();
        Gigi = new widget.ComboBox();
        jLabel45 = new widget.Label();
        Leher = new widget.ComboBox();
        jLabel46 = new widget.Label();
        Thoraks = new widget.ComboBox();
        jLabel49 = new widget.Label();
        Abdomen = new widget.ComboBox();
        jLabel50 = new widget.Label();
        Genital = new widget.ComboBox();
        jLabel51 = new widget.Label();
        Ekstremitas = new widget.ComboBox();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel99 = new widget.Label();
        PanelWall = new usu.widget.glass.PanelGlass();
        scrollPane8 = new widget.ScrollPane();
        KetLokalis = new widget.TextArea();
        jLabel79 = new widget.Label();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel100 = new widget.Label();
        scrollPane9 = new widget.ScrollPane();
        EKG = new widget.TextArea();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel101 = new widget.Label();
        scrollPane12 = new widget.ScrollPane();
        Diagnosis = new widget.TextArea();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel102 = new widget.Label();
        jLabel103 = new widget.Label();
        jLabel42 = new widget.Label();
        Mata = new widget.ComboBox();
        jLabel80 = new widget.Label();
        jLabel81 = new widget.Label();
        scrollPane10 = new widget.ScrollPane();
        Radiologi = new widget.TextArea();
        jLabel82 = new widget.Label();
        scrollPane11 = new widget.ScrollPane();
        Laborat = new widget.TextArea();
        scrollPane14 = new widget.ScrollPane();
        Tatalaksana = new widget.TextArea();
        Skalanyeri = new widget.TextBox();
        jLabel48 = new widget.Label();
        jLabel54 = new widget.Label();
        internalFrame4 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbTriase = new widget.Table();
        panelGlass9 = new widget.panelisi();
        jLabel19 = new widget.Label();
        DTPCari1 = new widget.Tanggal();
        jLabel21 = new widget.Label();
        DTPCari2 = new widget.Tanggal();
        jLabel6 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        jLabel7 = new widget.Label();
        LCount = new widget.Label();
        PanelAccor = new widget.PanelBiasa();
        ChkAccor = new widget.CekBox();
        FormMenu = new widget.PanelBiasa();
        jLabel34 = new widget.Label();
        TNoRM1 = new widget.TextBox();
        TPasien1 = new widget.TextBox();
        BtnPrint1 = new widget.Button();
        ScrollHTML = new widget.ScrollPane();
        LoadHTML = new widget.editorpane();
        internalFrame15 = new widget.InternalFrame();
        Scroll9 = new widget.ScrollPane();
        tbAwalMedisIGD = new widget.Table();
        panelGlass11 = new widget.panelisi();
        jLabel77 = new widget.Label();
        DTPCari5 = new widget.Tanggal();
        jLabel78 = new widget.Label();
        DTPCari6 = new widget.Tanggal();
        jLabel83 = new widget.Label();
        TCari2 = new widget.TextBox();
        BtnCari2 = new widget.Button();
        jLabel84 = new widget.Label();
        LCount2 = new widget.Label();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnHapus = new widget.Button();
        BtnEdit = new widget.Button();
        BtnPrint = new widget.Button();
        BtnAll = new widget.Button();
        BtnKeluar = new widget.Button();

        LoadHTML2.setBorder(null);
        LoadHTML2.setName("LoadHTML2"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Data Triase IGD ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        TabPilihan.setBackground(new java.awt.Color(255, 255, 254));
        TabPilihan.setForeground(new java.awt.Color(50, 50, 50));
        TabPilihan.setName("TabPilihan"); // NOI18N
        TabPilihan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabPilihanMouseClicked(evt);
            }
        });

        ScrollTriase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 253)));
        ScrollTriase.setName("ScrollTriase"); // NOI18N
        ScrollTriase.setOpaque(true);

        FormTriase.setBorder(null);
        FormTriase.setName("FormTriase"); // NOI18N
        FormTriase.setLayout(new java.awt.BorderLayout(1, 1));

        FormInput.setBorder(null);
        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(100, 104));
        FormInput.setLayout(null);

        jLabel4.setText("No.Rawat :");
        jLabel4.setName("jLabel4"); // NOI18N
        FormInput.add(jLabel4);
        jLabel4.setBounds(0, 10, 89, 23);

        TNoRw.setBackground(new java.awt.Color(245, 250, 240));
        TNoRw.setHighlighter(null);
        TNoRw.setName("TNoRw"); // NOI18N
        FormInput.add(TNoRw);
        TNoRw.setBounds(93, 10, 122, 23);

        TPasien.setBackground(new java.awt.Color(245, 250, 240));
        TPasien.setHighlighter(null);
        TPasien.setName("TPasien"); // NOI18N
        FormInput.add(TPasien);
        TPasien.setBounds(289, 10, 225, 23);

        TNoRM.setHighlighter(null);
        TNoRM.setName("TNoRM"); // NOI18N
        TNoRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNoRMActionPerformed(evt);
            }
        });
        FormInput.add(TNoRM);
        TNoRM.setBounds(217, 10, 70, 23);

        jLabel18.setText("Tgl.Kunjungan :");
        jLabel18.setName("jLabel18"); // NOI18N
        FormInput.add(jLabel18);
        jLabel18.setBounds(0, 40, 89, 23);

        TanggalKunjungan.setForeground(new java.awt.Color(50, 70, 50));
        TanggalKunjungan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09-05-2026 01:51:51" }));
        TanggalKunjungan.setDisplayFormat("dd-MM-yyyy HH:mm:ss");
        TanggalKunjungan.setName("TanggalKunjungan"); // NOI18N
        TanggalKunjungan.setOpaque(false);
        TanggalKunjungan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TanggalKunjunganKeyPressed(evt);
            }
        });
        FormInput.add(TanggalKunjungan);
        TanggalKunjungan.setBounds(93, 40, 135, 23);

        jLabel20.setText("Cara Masuk :");
        jLabel20.setName("jLabel20"); // NOI18N
        FormInput.add(jLabel20);
        jLabel20.setBounds(236, 40, 80, 23);

        CaraMasuk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jalan", "Brankar", "Kursi Roda", "Digendong" }));
        CaraMasuk.setName("CaraMasuk"); // NOI18N
        CaraMasuk.setPreferredSize(new java.awt.Dimension(55, 28));
        CaraMasuk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CaraMasukKeyPressed(evt);
            }
        });
        FormInput.add(CaraMasuk);
        CaraMasuk.setBounds(320, 40, 110, 23);

        jLabel22.setText("Transportasi :");
        jLabel22.setName("jLabel22"); // NOI18N
        FormInput.add(jLabel22);
        jLabel22.setBounds(531, 10, 80, 23);

        Transportasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "AGD", "Sendiri", "Swasta" }));
        Transportasi.setName("Transportasi"); // NOI18N
        Transportasi.setPreferredSize(new java.awt.Dimension(55, 28));
        Transportasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TransportasiKeyPressed(evt);
            }
        });
        FormInput.add(Transportasi);
        Transportasi.setBounds(615, 10, 100, 23);

        jLabel23.setText("Alasan Kedatangan :");
        jLabel23.setName("jLabel23"); // NOI18N
        FormInput.add(jLabel23);
        jLabel23.setBounds(431, 40, 130, 23);

        AlasanKedatangan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Datang Sendiri", "Polisi", "Rujukan", "-" }));
        AlasanKedatangan.setName("AlasanKedatangan"); // NOI18N
        AlasanKedatangan.setPreferredSize(new java.awt.Dimension(55, 28));
        AlasanKedatangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AlasanKedatanganKeyPressed(evt);
            }
        });
        FormInput.add(AlasanKedatangan);
        AlasanKedatangan.setBounds(565, 40, 150, 23);

        jLabel5.setText("Macam Kasus :");
        jLabel5.setName("jLabel5"); // NOI18N
        FormInput.add(jLabel5);
        jLabel5.setBounds(0, 70, 89, 23);

        KdKasus.setEditable(false);
        KdKasus.setHighlighter(null);
        KdKasus.setName("KdKasus"); // NOI18N
        KdKasus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KdKasusKeyPressed(evt);
            }
        });
        FormInput.add(KdKasus);
        KdKasus.setBounds(93, 70, 50, 23);

        NmKasus.setEditable(false);
        NmKasus.setName("NmKasus"); // NOI18N
        NmKasus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NmKasusKeyPressed(evt);
            }
        });
        FormInput.add(NmKasus);
        NmKasus.setBounds(145, 70, 250, 23);

        btnKasus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnKasus.setMnemonic('1');
        btnKasus.setToolTipText("Alt+1");
        btnKasus.setName("btnKasus"); // NOI18N
        btnKasus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKasusActionPerformed(evt);
            }
        });
        btnKasus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnKasusKeyPressed(evt);
            }
        });
        FormInput.add(btnKasus);
        btnKasus.setBounds(397, 70, 28, 23);

        KeteranganKedatangan.setName("KeteranganKedatangan"); // NOI18N
        KeteranganKedatangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganKedatanganKeyPressed(evt);
            }
        });
        FormInput.add(KeteranganKedatangan);
        KeteranganKedatangan.setBounds(520, 70, 195, 23);

        jLabel8.setText("Keterangan  :");
        jLabel8.setName("jLabel8"); // NOI18N
        FormInput.add(jLabel8);
        jLabel8.setBounds(430, 70, 86, 23);

        jLabel52.setText("Tgl.Lahir :");
        jLabel52.setName("jLabel52"); // NOI18N
        FormInput.add(jLabel52);
        jLabel52.setBounds(730, 10, 60, 23);

        TglLahir.setEditable(false);
        TglLahir.setHighlighter(null);
        TglLahir.setName("TglLahir"); // NOI18N
        FormInput.add(TglLahir);
        TglLahir.setBounds(790, 10, 80, 23);

        jLabel55.setText("J.K. :");
        jLabel55.setName("jLabel55"); // NOI18N
        FormInput.add(jLabel55);
        jLabel55.setBounds(890, 10, 30, 23);

        Jk.setEditable(false);
        Jk.setHighlighter(null);
        Jk.setName("Jk"); // NOI18N
        FormInput.add(Jk);
        Jk.setBounds(920, 10, 80, 23);

        Hubungan.setName("Hubungan"); // NOI18N
        Hubungan.setPreferredSize(new java.awt.Dimension(207, 23));
        Hubungan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HubunganKeyPressed(evt);
            }
        });
        FormInput.add(Hubungan);
        Hubungan.setBounds(920, 40, 80, 23);

        Anamnesis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Autoanamnesis", "Alloanamnesis" }));
        Anamnesis.setName("Anamnesis"); // NOI18N
        Anamnesis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AnamnesisKeyPressed(evt);
            }
        });
        FormInput.add(Anamnesis);
        Anamnesis.setBounds(790, 40, 128, 23);

        jLabel73.setText("Anamnesis :");
        jLabel73.setName("jLabel73"); // NOI18N
        FormInput.add(jLabel73);
        jLabel73.setBounds(720, 40, 70, 23);

        FormTriase.add(FormInput, java.awt.BorderLayout.PAGE_START);

        TabTriase.setBackground(new java.awt.Color(255, 255, 254));
        TabTriase.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        TabTriase.setForeground(new java.awt.Color(50, 50, 50));
        TabTriase.setName("TabTriase"); // NOI18N
        TabTriase.setPreferredSize(new java.awt.Dimension(700, 500));
        TabTriase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabTriaseMouseClicked(evt);
            }
        });

        scrollPane15.setName("scrollPane15"); // NOI18N

        internalFrame5.setBorder(null);
        internalFrame5.setName("internalFrame5"); // NOI18N
        internalFrame5.setPreferredSize(new java.awt.Dimension(1500, 900));
        internalFrame5.setLayout(new java.awt.BorderLayout());

        internalFrame7.setBorder(null);
        internalFrame7.setName("internalFrame7"); // NOI18N
        internalFrame7.setPreferredSize(new java.awt.Dimension(0, 104));
        internalFrame7.setLayout(null);

        scrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane1.setName("scrollPane1"); // NOI18N

        PrimerKeluhanUtama.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PrimerKeluhanUtama.setColumns(20);
        PrimerKeluhanUtama.setRows(5);
        PrimerKeluhanUtama.setName("PrimerKeluhanUtama"); // NOI18N
        PrimerKeluhanUtama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrimerKeluhanUtamaKeyPressed(evt);
            }
        });
        scrollPane1.setViewportView(PrimerKeluhanUtama);

        internalFrame7.add(scrollPane1);
        scrollPane1.setBounds(97, 10, 320, 53);

        jLabel9.setText("Keluhan Utama :");
        jLabel9.setName("jLabel9"); // NOI18N
        internalFrame7.add(jLabel9);
        jLabel9.setBounds(0, 10, 93, 23);

        jLabel24.setText("Kebutuhan Khusus :");
        jLabel24.setName("jLabel24"); // NOI18N
        internalFrame7.add(jLabel24);
        jLabel24.setBounds(360, 70, 119, 23);

        PrimerKubutuhanKusus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "UPPA", "Airborne", "Dekontaminan" }));
        PrimerKubutuhanKusus.setName("PrimerKubutuhanKusus"); // NOI18N
        PrimerKubutuhanKusus.setPreferredSize(new java.awt.Dimension(55, 28));
        PrimerKubutuhanKusus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrimerKubutuhanKususKeyPressed(evt);
            }
        });
        internalFrame7.add(PrimerKubutuhanKusus);
        PrimerKubutuhanKusus.setBounds(483, 70, 202, 23);

        jLabel10.setText("Suhu (C) :");
        jLabel10.setName("jLabel10"); // NOI18N
        internalFrame7.add(jLabel10);
        jLabel10.setBounds(420, 10, 59, 23);

        PrimerSuhu.setFocusTraversalPolicyProvider(true);
        PrimerSuhu.setName("PrimerSuhu"); // NOI18N
        PrimerSuhu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrimerSuhuKeyPressed(evt);
            }
        });
        internalFrame7.add(PrimerSuhu);
        PrimerSuhu.setBounds(483, 10, 55, 23);

        jLabel16.setText("Saturasi O²(%) :");
        jLabel16.setName("jLabel16"); // NOI18N
        internalFrame7.add(jLabel16);
        jLabel16.setBounds(0, 70, 93, 23);

        PrimerSaturasi.setFocusTraversalPolicyProvider(true);
        PrimerSaturasi.setName("PrimerSaturasi"); // NOI18N
        PrimerSaturasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrimerSaturasiKeyPressed(evt);
            }
        });
        internalFrame7.add(PrimerSaturasi);
        PrimerSaturasi.setBounds(97, 70, 55, 23);

        PrimerNadi.setFocusTraversalPolicyProvider(true);
        PrimerNadi.setName("PrimerNadi"); // NOI18N
        PrimerNadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrimerNadiActionPerformed(evt);
            }
        });
        PrimerNadi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrimerNadiKeyPressed(evt);
            }
        });
        internalFrame7.add(PrimerNadi);
        PrimerNadi.setBounds(630, 40, 55, 23);

        jLabel26.setText("Nadi(/menit) :");
        jLabel26.setName("jLabel26"); // NOI18N
        internalFrame7.add(jLabel26);
        jLabel26.setBounds(547, 40, 79, 23);

        PrimerRespirasi.setHighlighter(null);
        PrimerRespirasi.setName("PrimerRespirasi"); // NOI18N
        PrimerRespirasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrimerRespirasiKeyPressed(evt);
            }
        });
        internalFrame7.add(PrimerRespirasi);
        PrimerRespirasi.setBounds(284, 70, 55, 23);

        jLabel27.setText("Respirasi(/menit) :");
        jLabel27.setName("jLabel27"); // NOI18N
        internalFrame7.add(jLabel27);
        jLabel27.setBounds(180, 70, 100, 23);

        PrimerTensi.setHighlighter(null);
        PrimerTensi.setName("PrimerTensi"); // NOI18N
        PrimerTensi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrimerTensiKeyPressed(evt);
            }
        });
        internalFrame7.add(PrimerTensi);
        PrimerTensi.setBounds(483, 40, 55, 23);

        jLabel11.setText("Tensi :");
        jLabel11.setName("jLabel11"); // NOI18N
        internalFrame7.add(jLabel11);
        jLabel11.setBounds(420, 40, 59, 23);

        internalFrame5.add(internalFrame7, java.awt.BorderLayout.PAGE_START);

        internalFrame8.setBorder(null);
        internalFrame8.setName("internalFrame8"); // NOI18N
        internalFrame8.setPreferredSize(new java.awt.Dimension(0, 74));
        internalFrame8.setLayout(null);

        jLabel12.setText("Dokter/Petugas IGD :");
        jLabel12.setName("jLabel12"); // NOI18N
        internalFrame8.add(jLabel12);
        jLabel12.setBounds(212, 40, 120, 23);

        PrimerKodePetugas.setEditable(false);
        PrimerKodePetugas.setHighlighter(null);
        PrimerKodePetugas.setName("PrimerKodePetugas"); // NOI18N
        PrimerKodePetugas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrimerKodePetugasKeyPressed(evt);
            }
        });
        internalFrame8.add(PrimerKodePetugas);
        PrimerKodePetugas.setBounds(336, 40, 110, 23);

        PrimerNamaPetugas.setEditable(false);
        PrimerNamaPetugas.setName("PrimerNamaPetugas"); // NOI18N
        PrimerNamaPetugas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrimerNamaPetugasKeyPressed(evt);
            }
        });
        internalFrame8.add(PrimerNamaPetugas);
        PrimerNamaPetugas.setBounds(448, 40, 210, 23);

        btnPrimerPetugas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPrimerPetugas.setMnemonic('1');
        btnPrimerPetugas.setToolTipText("Alt+1");
        btnPrimerPetugas.setName("btnPrimerPetugas"); // NOI18N
        btnPrimerPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimerPetugasActionPerformed(evt);
            }
        });
        btnPrimerPetugas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPrimerPetugasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnPrimerPetugasKeyReleased(evt);
            }
        });
        internalFrame8.add(btnPrimerPetugas);
        btnPrimerPetugas.setBounds(660, 40, 28, 23);

        jLabel28.setText("Plan/Keputusan :");
        jLabel28.setName("jLabel28"); // NOI18N
        internalFrame8.add(jLabel28);
        jLabel28.setBounds(362, 10, 90, 23);

        PrimerTanggalTriase.setForeground(new java.awt.Color(50, 70, 50));
        PrimerTanggalTriase.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09-05-2026 01:51:53" }));
        PrimerTanggalTriase.setDisplayFormat("dd-MM-yyyy HH:mm:ss");
        PrimerTanggalTriase.setName("PrimerTanggalTriase"); // NOI18N
        PrimerTanggalTriase.setOpaque(false);
        PrimerTanggalTriase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrimerTanggalTriaseKeyPressed(evt);
            }
        });
        internalFrame8.add(PrimerTanggalTriase);
        PrimerTanggalTriase.setBounds(69, 40, 135, 23);

        jLabel29.setText("Tgl.Triase :");
        jLabel29.setName("jLabel29"); // NOI18N
        internalFrame8.add(jLabel29);
        jLabel29.setBounds(0, 40, 65, 23);

        buttonGroup1.add(PrimerResusitasi);
        PrimerResusitasi.setForeground(new java.awt.Color(170, 0, 0));
        PrimerResusitasi.setSelected(true);
        PrimerResusitasi.setText("Ruang Resusitasi");
        PrimerResusitasi.setName("PrimerResusitasi"); // NOI18N
        PrimerResusitasi.setPreferredSize(new java.awt.Dimension(40, 20));
        internalFrame8.add(PrimerResusitasi);
        PrimerResusitasi.setBounds(456, 10, 120, 23);

        buttonGroup1.add(PrimerKritis);
        PrimerKritis.setForeground(new java.awt.Color(250, 0, 0));
        PrimerKritis.setText("Ruang Kritis");
        PrimerKritis.setName("PrimerKritis"); // NOI18N
        internalFrame8.add(PrimerKritis);
        PrimerKritis.setBounds(590, 10, 100, 23);

        label14.setText("Catatan :");
        label14.setName("label14"); // NOI18N
        label14.setPreferredSize(new java.awt.Dimension(60, 23));
        internalFrame8.add(label14);
        label14.setBounds(0, 10, 65, 23);

        PrimerCatatan.setToolTipText("Alt+C");
        PrimerCatatan.setName("PrimerCatatan"); // NOI18N
        PrimerCatatan.setPreferredSize(new java.awt.Dimension(140, 23));
        PrimerCatatan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrimerCatatanKeyPressed(evt);
            }
        });
        internalFrame8.add(PrimerCatatan);
        PrimerCatatan.setBounds(69, 10, 290, 23);

        buttonGroup1.add(SekunderZonaKuning1);
        SekunderZonaKuning1.setForeground(new java.awt.Color(200, 200, 0));
        SekunderZonaKuning1.setText("Zona Kuning");
        SekunderZonaKuning1.setName("SekunderZonaKuning1"); // NOI18N
        SekunderZonaKuning1.setPreferredSize(new java.awt.Dimension(40, 20));
        SekunderZonaKuning1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SekunderZonaKuning1ActionPerformed(evt);
            }
        });
        internalFrame8.add(SekunderZonaKuning1);
        SekunderZonaKuning1.setBounds(690, 10, 120, 23);

        buttonGroup1.add(SekunderZonaHijau1);
        SekunderZonaHijau1.setForeground(new java.awt.Color(0, 170, 0));
        SekunderZonaHijau1.setText("Zona Hijau");
        SekunderZonaHijau1.setName("SekunderZonaHijau1"); // NOI18N
        internalFrame8.add(SekunderZonaHijau1);
        SekunderZonaHijau1.setBounds(810, 10, 140, 23);

        internalFrame5.add(internalFrame8, java.awt.BorderLayout.PAGE_END);

        internalFrame3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 4, 0, 4));
        internalFrame3.setName("internalFrame3"); // NOI18N
        internalFrame3.setLayout(new java.awt.BorderLayout(1, 1));

        internalFrame9.setBorder(null);
        internalFrame9.setName("internalFrame9"); // NOI18N
        internalFrame9.setPreferredSize(new java.awt.Dimension(0, 74));
        internalFrame9.setLayout(new java.awt.BorderLayout(2, 1));

        jPanel1.setName("jPanel1"); // NOI18N
        internalFrame9.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(280, 102));
        jPanel3.setLayout(new java.awt.BorderLayout(1, 1));

        panelisi5.setBorder(null);
        panelisi5.setName("panelisi5"); // NOI18N
        panelisi5.setPreferredSize(new java.awt.Dimension(100, 43));
        panelisi5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 9));

        label10.setText("Key Word :");
        label10.setName("label10"); // NOI18N
        label10.setPreferredSize(new java.awt.Dimension(60, 23));
        panelisi5.add(label10);

        TCariPemeriksaan.setToolTipText("Alt+C");
        TCariPemeriksaan.setName("TCariPemeriksaan"); // NOI18N
        TCariPemeriksaan.setPreferredSize(new java.awt.Dimension(140, 23));
        TCariPemeriksaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariPemeriksaanKeyPressed(evt);
            }
        });
        panelisi5.add(TCariPemeriksaan);

        BtnCariPemeriksaan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCariPemeriksaan.setMnemonic('1');
        BtnCariPemeriksaan.setToolTipText("Alt+1");
        BtnCariPemeriksaan.setName("BtnCariPemeriksaan"); // NOI18N
        BtnCariPemeriksaan.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCariPemeriksaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariPemeriksaanActionPerformed(evt);
            }
        });
        BtnCariPemeriksaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariPemeriksaanKeyPressed(evt);
            }
        });
        panelisi5.add(BtnCariPemeriksaan);

        BtnTambahPemeriksaan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/plus_16.png"))); // NOI18N
        BtnTambahPemeriksaan.setMnemonic('3');
        BtnTambahPemeriksaan.setToolTipText("Alt+3");
        BtnTambahPemeriksaan.setName("BtnTambahPemeriksaan"); // NOI18N
        BtnTambahPemeriksaan.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnTambahPemeriksaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahPemeriksaanActionPerformed(evt);
            }
        });
        panelisi5.add(BtnTambahPemeriksaan);

        jPanel3.add(panelisi5, java.awt.BorderLayout.PAGE_END);

        Scroll2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 253)));
        Scroll2.setName("Scroll2"); // NOI18N
        Scroll2.setOpaque(true);

        tbPemeriksaan.setName("tbPemeriksaan"); // NOI18N
        tbPemeriksaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPemeriksaanMouseClicked(evt);
            }
        });
        tbPemeriksaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbPemeriksaanKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbPemeriksaanKeyReleased(evt);
            }
        });
        Scroll2.setViewportView(tbPemeriksaan);

        jPanel3.add(Scroll2, java.awt.BorderLayout.CENTER);

        internalFrame9.add(jPanel3, java.awt.BorderLayout.WEST);

        internalFrame3.add(internalFrame9, java.awt.BorderLayout.WEST);

        internalFrame2.setName("internalFrame2"); // NOI18N
        internalFrame2.setLayout(new java.awt.BorderLayout());

        panelisi3.setName("panelisi3"); // NOI18N
        panelisi3.setPreferredSize(new java.awt.Dimension(2, 30));
        panelisi3.setLayout(new java.awt.BorderLayout());

        panelisi1.setName("panelisi1"); // NOI18N
        panelisi1.setPreferredSize(new java.awt.Dimension(700, 12));
        panelisi1.setLayout(new java.awt.BorderLayout());

        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("ALGORITMA TRIASE EMERGENCY SEVERITY INDEX (ESI)");
        label1.setName("label1"); // NOI18N
        panelisi1.add(label1, java.awt.BorderLayout.CENTER);

        panelisi3.add(panelisi1, java.awt.BorderLayout.LINE_START);

        panelisi2.setName("panelisi2"); // NOI18N
        panelisi2.setLayout(new java.awt.BorderLayout());

        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setText("PENILAIAN BAYI BARU LAHIR");
        label2.setName("label2"); // NOI18N
        panelisi2.add(label2, java.awt.BorderLayout.CENTER);

        panelisi3.add(panelisi2, java.awt.BorderLayout.CENTER);

        internalFrame2.add(panelisi3, java.awt.BorderLayout.PAGE_START);

        panelisi4.setName("panelisi4"); // NOI18N
        panelisi4.setPreferredSize(new java.awt.Dimension(700, 12));

        label3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label3.setText("BERAPA JENIS SUMBER DAYA IGD YANG DIBUTUHKAN ?");
        label3.setName("label3"); // NOI18N

        cbPrioritas543.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "TIDAK ADA", "SATU", "BANYAK (>2)" }));
        cbPrioritas543.setName("cbPrioritas543"); // NOI18N
        cbPrioritas543.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPrioritas543ActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"< 3 bln", "> 180", "> 50", "> 38", null},
                {"3 bln - 3 th", "> 160", "> 40", "> 38", "< 92%"},
                {"3-8 th", "> 140", "> 30", null, null},
                {"> 8th", "> 100", "> 20", null, null}
            },
            new String [] {
                "UMUR", "HR (x/mnt)", "RR (x/mnt)", "SUHU", "SpO2"
            }
        ));
        table1.setName("table1"); // NOI18N
        jScrollPane1.setViewportView(table1);

        panelisi10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelisi10.setName("panelisi10"); // NOI18N
        panelisi10.setLayout(new java.awt.BorderLayout());

        cbPrioritas1.setText("PERLU TINDAKAN LIVE SAVING / RESUSITASI SEGERA");
        cbPrioritas1.setName("cbPrioritas1"); // NOI18N
        cbPrioritas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPrioritas1ActionPerformed(evt);
            }
        });
        panelisi10.add(cbPrioritas1, java.awt.BorderLayout.CENTER);

        panelisi11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelisi11.setName("panelisi11"); // NOI18N
        panelisi11.setLayout(new java.awt.BorderLayout());

        cbPrioritas2b.setText("RISIKO TINGGI");
        cbPrioritas2b.setName("cbPrioritas2b"); // NOI18N
        cbPrioritas2b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPrioritas2bActionPerformed(evt);
            }
        });
        panelisi11.add(cbPrioritas2b, java.awt.BorderLayout.CENTER);

        cbPrioritas2a.setText("KEBINGUNGAN / LETARGIS ? DISORIENTASI");
        cbPrioritas2a.setName("cbPrioritas2a"); // NOI18N
        cbPrioritas2a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPrioritas2aActionPerformed(evt);
            }
        });
        panelisi11.add(cbPrioritas2a, java.awt.BorderLayout.PAGE_START);

        cbPrioritas2c.setText("NYERI / DISTRES BERAT");
        cbPrioritas2c.setName("cbPrioritas2c"); // NOI18N
        cbPrioritas2c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPrioritas2cActionPerformed(evt);
            }
        });
        panelisi11.add(cbPrioritas2c, java.awt.BorderLayout.PAGE_END);

        panelisi16.setName("panelisi16"); // NOI18N
        panelisi16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label16.setText("DERAJAT NYERI");
        label16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label16.setName("label16"); // NOI18N
        panelisi16.add(label16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        label19.setText("FREKUENSI :");
        label19.setName("label19"); // NOI18N
        panelisi16.add(label19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 70, 20));

        label20.setText("NYERI :");
        label20.setName("label20"); // NOI18N
        panelisi16.add(label20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, -1));

        label21.setText("LOKASI :");
        label21.setName("label21"); // NOI18N
        panelisi16.add(label21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, 20));

        frekuensinyeri.setName("frekuensinyeri"); // NOI18N
        panelisi16.add(frekuensinyeri, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 200, -1));

        lokasinyeri.setName("lokasinyeri"); // NOI18N
        panelisi16.add(lokasinyeri, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 200, -1));

        label22.setText("DURASI :");
        label22.setName("label22"); // NOI18N
        panelisi16.add(label22, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 70, 20));

        durasinyeri.setName("durasinyeri"); // NOI18N
        panelisi16.add(durasinyeri, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 200, -1));

        label23.setText("GAMBARAN NYERI :");
        label23.setName("label23"); // NOI18N
        panelisi16.add(label23, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 110, 20));

        gambarannyeri.setName("gambarannyeri"); // NOI18N
        panelisi16.add(gambarannyeri, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 200, -1));

        comboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tidak", "Ya", "Akut", "Kronis" }));
        comboBox1.setName("comboBox1"); // NOI18N
        comboBox1.setPreferredSize(new java.awt.Dimension(72, 22));
        panelisi16.add(comboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 28, -1, -1));

        panelisi17.setName("panelisi17"); // NOI18N
        panelisi17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label24.setText("SKALA NYERI");
        label24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label24.setName("label24"); // NOI18N
        panelisi17.add(label24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 698, -1));

        panelisi18.setName("panelisi18"); // NOI18N
        panelisi18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelWall1.setBackground(new java.awt.Color(29, 29, 29));
        PanelWall1.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/nyeri.png"))); // NOI18N
        PanelWall1.setBackgroundImageType(usu.widget.constan.BackgroundConstan.BACKGROUND_IMAGE_STRECT);
        PanelWall1.setPreferredSize(new java.awt.Dimension(200, 200));
        PanelWall1.setRound(false);
        PanelWall1.setWarna(new java.awt.Color(110, 110, 110));
        PanelWall1.setLayout(null);
        panelisi18.add(PanelWall1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 410, 210));

        panelisi17.add(panelisi18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 18, 600, 191));

        jLabel25.setText("Nyeri :");
        jLabel25.setName("jLabel25"); // NOI18N
        panelisi17.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 79, 23));

        PrimerNyeri.setHighlighter(null);
        PrimerNyeri.setName("PrimerNyeri"); // NOI18N
        PrimerNyeri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrimerNyeriKeyPressed(evt);
            }
        });
        panelisi17.add(PrimerNyeri, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 80, 23));

        cbPrioritas3.setText("Ya");
        cbPrioritas3.setName("cbPrioritas3"); // NOI18N

        cbPrioritas3tidak.setText("Tidak");
        cbPrioritas3tidak.setName("cbPrioritas3tidak"); // NOI18N
        cbPrioritas3tidak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPrioritas3tidakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelisi4Layout = new javax.swing.GroupLayout(panelisi4);
        panelisi4.setLayout(panelisi4Layout);
        panelisi4Layout.setHorizontalGroup(
            panelisi4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelisi16, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelisi17, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelisi4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelisi4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelisi10, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelisi11, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelisi4Layout.createSequentialGroup()
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cbPrioritas543, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbPrioritas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelisi4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cbPrioritas3tidak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelisi4Layout.setVerticalGroup(
            panelisi4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelisi4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(panelisi10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panelisi11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panelisi4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelisi4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbPrioritas543, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbPrioritas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(panelisi4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelisi4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(cbPrioritas3tidak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(panelisi16, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelisi17, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        internalFrame2.add(panelisi4, java.awt.BorderLayout.LINE_START);

        panelisi9.setName("panelisi9"); // NOI18N
        panelisi9.setLayout(new java.awt.BorderLayout());

        panelisi12.setName("panelisi12"); // NOI18N
        panelisi12.setPreferredSize(new java.awt.Dimension(12, 150));
        panelisi12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label4.setText("Tonus Otot Baik");
        label4.setName("label4"); // NOI18N
        panelisi12.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        label5.setText("Cukup Bulan");
        label5.setName("label5"); // NOI18N
        panelisi12.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        label6.setText("Cairan Amnion Jernih");
        label6.setName("label6"); // NOI18N
        panelisi12.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        label7.setText("Pernafasan / Menangis");
        label7.setName("label7"); // NOI18N
        panelisi12.add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        label8.setText("SKOR APGAR :");
        label8.setName("label8"); // NOI18N
        panelisi12.add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        cukupbulan.add(cekTidak1);
        cekTidak1.setText("Tidak");
        cekTidak1.setName("cekTidak1"); // NOI18N
        panelisi12.add(cekTidak1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        cukupbulan.add(cekYa1);
        cekYa1.setText("Ya");
        cekYa1.setName("cekYa1"); // NOI18N
        panelisi12.add(cekYa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        cairanamnion.add(cekTidak2);
        cekTidak2.setText("Tidak");
        cekTidak2.setName("cekTidak2"); // NOI18N
        panelisi12.add(cekTidak2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        cairanamnion.add(cekYa2);
        cekYa2.setText("Ya");
        cekYa2.setName("cekYa2"); // NOI18N
        panelisi12.add(cekYa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        pernafasan.add(cekTidak3);
        cekTidak3.setText("Tidak");
        cekTidak3.setName("cekTidak3"); // NOI18N
        panelisi12.add(cekTidak3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        pernafasan.add(cekYa3);
        cekYa3.setText("Ya");
        cekYa3.setName("cekYa3"); // NOI18N
        panelisi12.add(cekYa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        tonus.add(cekTidak4);
        cekTidak4.setText("Tidak");
        cekTidak4.setName("cekTidak4"); // NOI18N
        panelisi12.add(cekTidak4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        tonus.add(cekYa4);
        cekYa4.setText("Ya");
        cekYa4.setName("cekYa4"); // NOI18N
        panelisi12.add(cekYa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        panelisi9.add(panelisi12, java.awt.BorderLayout.PAGE_START);

        panelisi13.setName("panelisi13"); // NOI18N
        panelisi13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelisi14.setName("panelisi14"); // NOI18N
        panelisi14.setPreferredSize(new java.awt.Dimension(2, 20));
        panelisi14.setLayout(new java.awt.BorderLayout());

        label9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label9.setText("Kriteria Penilaian Anak");
        label9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label9.setName("label9"); // NOI18N
        label9.setPreferredSize(new java.awt.Dimension(111, 20));
        panelisi14.add(label9, java.awt.BorderLayout.CENTER);

        panelisi13.add(panelisi14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 409, -1));

        panelisi15.setName("panelisi15"); // NOI18N
        panelisi15.setPreferredSize(new java.awt.Dimension(156, 150));
        panelisi15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label17.setText("Status Psikologi :");
        label17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label17.setName("label17"); // NOI18N
        panelisi15.add(label17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        cekBox5.setText("Suspek COVID 19 aktif");
        cekBox5.setName("cekBox5"); // NOI18N
        cekBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekBox5ActionPerformed(evt);
            }
        });
        panelisi15.add(cekBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        cekBox6.setText("Cemas");
        cekBox6.setName("cekBox6"); // NOI18N
        cekBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekBox6ActionPerformed(evt);
            }
        });
        panelisi15.add(cekBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        cekBox7.setText("TB Aktif");
        cekBox7.setName("cekBox7"); // NOI18N
        cekBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekBox7ActionPerformed(evt);
            }
        });
        panelisi15.add(cekBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        cekBox8.setText("TB dalam pengobatan");
        cekBox8.setName("cekBox8"); // NOI18N
        cekBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekBox8ActionPerformed(evt);
            }
        });
        panelisi15.add(cekBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        label18.setText("Kriteria Isolasi :");
        label18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label18.setName("label18"); // NOI18N
        panelisi15.add(label18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cekBox9.setText("Batuk lebih dari 2 minggu");
        cekBox9.setName("cekBox9"); // NOI18N
        cekBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekBox9ActionPerformed(evt);
            }
        });
        panelisi15.add(cekBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        cekBox10.setText("Afek Normal");
        cekBox10.setName("cekBox10"); // NOI18N
        cekBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekBox10ActionPerformed(evt);
            }
        });
        panelisi15.add(cekBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cekBox11.setText("Agitasi");
        cekBox11.setName("cekBox11"); // NOI18N
        cekBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekBox11ActionPerformed(evt);
            }
        });
        panelisi15.add(cekBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        cekBox12.setText("Depresi");
        cekBox12.setName("cekBox12"); // NOI18N
        cekBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekBox12ActionPerformed(evt);
            }
        });
        panelisi15.add(cekBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        panelisi13.add(panelisi15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 21, 409, 220));

        label25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label25.setText("DISPOSISI PASIEN");
        label25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label25.setName("label25"); // NOI18N
        panelisi13.add(label25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 410, 30));

        prioritas2.setBackground(new java.awt.Color(255, 255, 0));
        prioritas2.setName("prioritas2"); // NOI18N
        prioritas2.setPreferredSize(new java.awt.Dimension(151, 25));
        prioritas2.setWarnaAtas(new java.awt.Color(255, 255, 0));
        prioritas2.setWarnaBawah(new java.awt.Color(255, 255, 0));
        prioritas2.setLayout(new java.awt.BorderLayout());

        label27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label27.setText("Prioritas 2 ( ESI 3)");
        label27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label27.setName("label27"); // NOI18N
        prioritas2.add(label27, java.awt.BorderLayout.CENTER);

        panelisi13.add(prioritas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 300, 40));

        prioritas1.setBackground(new java.awt.Color(255, 51, 0));
        prioritas1.setName("prioritas1"); // NOI18N
        prioritas1.setPreferredSize(new java.awt.Dimension(151, 25));
        prioritas1.setWarnaAtas(new java.awt.Color(255, 51, 0));
        prioritas1.setWarnaBawah(new java.awt.Color(255, 51, 0));
        prioritas1.setLayout(new java.awt.BorderLayout());

        label26.setForeground(new java.awt.Color(255, 255, 255));
        label26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label26.setText("Prioritas 1 ( ESI 1, ESI 2)");
        label26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label26.setName("label26"); // NOI18N
        label26.setPreferredSize(new java.awt.Dimension(149, 20));
        prioritas1.add(label26, java.awt.BorderLayout.CENTER);

        panelisi13.add(prioritas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 300, 40));

        prioritas4.setBackground(new java.awt.Color(0, 0, 0));
        prioritas4.setForeground(new java.awt.Color(255, 255, 255));
        prioritas4.setName("prioritas4"); // NOI18N
        prioritas4.setWarnaAtas(new java.awt.Color(0, 0, 0));
        prioritas4.setWarnaBawah(new java.awt.Color(0, 0, 0));
        prioritas4.setLayout(new java.awt.BorderLayout());

        label29.setForeground(new java.awt.Color(255, 255, 255));
        label29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label29.setText("D.O.A");
        label29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label29.setName("label29"); // NOI18N
        prioritas4.add(label29, java.awt.BorderLayout.CENTER);

        panelisi13.add(prioritas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 300, 40));

        prioritas3.setBackground(new java.awt.Color(51, 102, 0));
        prioritas3.setName("prioritas3"); // NOI18N
        prioritas3.setPreferredSize(new java.awt.Dimension(151, 25));
        prioritas3.setWarnaAtas(new java.awt.Color(51, 102, 0));
        prioritas3.setWarnaBawah(new java.awt.Color(51, 102, 0));
        prioritas3.setLayout(new java.awt.BorderLayout());

        label28.setForeground(new java.awt.Color(255, 255, 255));
        label28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label28.setText("Prioritas 3 ( ESI 4, ESI 5)");
        label28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label28.setName("label28"); // NOI18N
        prioritas3.add(label28, java.awt.BorderLayout.CENTER);

        panelisi13.add(prioritas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 300, 40));

        panelisi9.add(panelisi13, java.awt.BorderLayout.CENTER);

        internalFrame2.add(panelisi9, java.awt.BorderLayout.CENTER);

        internalFrame3.add(internalFrame2, java.awt.BorderLayout.CENTER);

        internalFrame5.add(internalFrame3, java.awt.BorderLayout.CENTER);

        scrollPane15.setViewportView(internalFrame5);

        TabTriase.addTab("Triase IGD", scrollPane15);

        scrollInput.setName("scrollInput"); // NOI18N
        scrollInput.setPreferredSize(new java.awt.Dimension(102, 557));

        FormInput1.setBackground(new java.awt.Color(255, 255, 255));
        FormInput1.setBorder(null);
        FormInput1.setName("FormInput1"); // NOI18N
        FormInput1.setPreferredSize(new java.awt.Dimension(870, 1500));
        FormInput1.setLayout(null);

        jLabel53.setText("Riwayat Pengunaan Obat :");
        jLabel53.setName("jLabel53"); // NOI18N
        FormInput1.add(jLabel53);
        jLabel53.setBounds(10, 130, 172, 23);

        jLabel56.setText("BB :");
        jLabel56.setName("jLabel56"); // NOI18N
        FormInput1.add(jLabel56);
        jLabel56.setBounds(770, 200, 30, 23);

        BB.setFocusTraversalPolicyProvider(true);
        BB.setName("BB"); // NOI18N
        BB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BBKeyPressed(evt);
            }
        });
        FormInput1.add(BB);
        BB.setBounds(800, 200, 45, 23);

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel57.setText("Kg");
        jLabel57.setName("jLabel57"); // NOI18N
        FormInput1.add(jLabel57);
        jLabel57.setBounds(850, 200, 30, 23);

        TB.setFocusTraversalPolicyProvider(true);
        TB.setName("TB"); // NOI18N
        TB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TBKeyPressed(evt);
            }
        });
        FormInput1.add(TB);
        TB.setBounds(690, 200, 45, 23);

        jLabel58.setText("TB :");
        jLabel58.setName("jLabel58"); // NOI18N
        FormInput1.add(jLabel58);
        jLabel58.setBounds(660, 200, 30, 23);

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel59.setText("x/menit");
        jLabel59.setName("jLabel59"); // NOI18N
        FormInput1.add(jLabel59);
        jLabel59.setBounds(340, 230, 50, 23);

        Nadi.setFocusTraversalPolicyProvider(true);
        Nadi.setName("Nadi"); // NOI18N
        Nadi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NadiKeyPressed(evt);
            }
        });
        FormInput1.add(Nadi);
        Nadi.setBounds(290, 230, 45, 23);

        jLabel60.setText("Nadi :");
        jLabel60.setName("jLabel60"); // NOI18N
        FormInput1.add(jLabel60);
        jLabel60.setBounds(250, 230, 40, 23);

        jLabel61.setText("Suhu :");
        jLabel61.setName("jLabel61"); // NOI18N
        FormInput1.add(jLabel61);
        jLabel61.setBounds(500, 230, 40, 23);

        Suhu.setFocusTraversalPolicyProvider(true);
        Suhu.setName("Suhu"); // NOI18N
        Suhu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SuhuKeyPressed(evt);
            }
        });
        FormInput1.add(Suhu);
        Suhu.setBounds(540, 230, 45, 23);

        jLabel62.setText("TD :");
        jLabel62.setName("jLabel62"); // NOI18N
        FormInput1.add(jLabel62);
        jLabel62.setBounds(10, 230, 127, 23);

        TD.setFocusTraversalPolicyProvider(true);
        TD.setName("TD"); // NOI18N
        TD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TDKeyPressed(evt);
            }
        });
        FormInput1.add(TD);
        TD.setBounds(150, 230, 76, 23);

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel63.setText("°C");
        jLabel63.setName("jLabel63"); // NOI18N
        FormInput1.add(jLabel63);
        jLabel63.setBounds(590, 230, 30, 23);

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("mmHg");
        jLabel64.setName("jLabel64"); // NOI18N
        FormInput1.add(jLabel64);
        jLabel64.setBounds(230, 230, 50, 23);

        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel65.setText(" cm");
        jLabel65.setName("jLabel65"); // NOI18N
        FormInput1.add(jLabel65);
        jLabel65.setBounds(740, 200, 30, 23);

        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel66.setText("x/menit");
        jLabel66.setName("jLabel66"); // NOI18N
        FormInput1.add(jLabel66);
        jLabel66.setBounds(460, 230, 50, 23);

        RR.setFocusTraversalPolicyProvider(true);
        RR.setName("RR"); // NOI18N
        RR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RRKeyPressed(evt);
            }
        });
        FormInput1.add(RR);
        RR.setBounds(410, 230, 45, 23);

        jLabel67.setText("RR :");
        jLabel67.setName("jLabel67"); // NOI18N
        FormInput1.add(jLabel67);
        jLabel67.setBounds(370, 230, 40, 23);

        jLabel68.setText("Riwayat Alergi :");
        jLabel68.setName("jLabel68"); // NOI18N
        FormInput1.add(jLabel68);
        jLabel68.setBounds(450, 130, 150, 23);

        Alergi.setFocusTraversalPolicyProvider(true);
        Alergi.setName("Alergi"); // NOI18N
        Alergi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AlergiKeyPressed(evt);
            }
        });
        FormInput1.add(Alergi);
        Alergi.setBounds(610, 130, 260, 23);

        scrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane6.setName("scrollPane6"); // NOI18N

        KeluhanUtama.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        KeluhanUtama.setColumns(20);
        KeluhanUtama.setRows(5);
        KeluhanUtama.setName("KeluhanUtama"); // NOI18N
        KeluhanUtama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeluhanUtamaKeyPressed(evt);
            }
        });
        scrollPane6.setViewportView(KeluhanUtama);

        FormInput1.add(scrollPane6);
        scrollPane6.setBounds(140, 30, 310, 43);

        jLabel69.setText("Riwayat Penyakit Sekarang :");
        jLabel69.setName("jLabel69"); // NOI18N
        FormInput1.add(jLabel69);
        jLabel69.setBounds(450, 30, 150, 23);

        scrollPane13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane13.setName("scrollPane13"); // NOI18N

        RPD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        RPD.setColumns(20);
        RPD.setRows(5);
        RPD.setName("RPD"); // NOI18N
        RPD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RPDKeyPressed(evt);
            }
        });
        scrollPane13.setViewportView(RPD);

        FormInput1.add(scrollPane13);
        scrollPane13.setBounds(610, 80, 260, 43);

        jLabel70.setText("Riwayat Penyakit Dahulu :");
        jLabel70.setName("jLabel70"); // NOI18N
        FormInput1.add(jLabel70);
        jLabel70.setBounds(450, 80, 150, 23);

        scrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane3.setName("scrollPane3"); // NOI18N

        RPK.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        RPK.setColumns(20);
        RPK.setRows(5);
        RPK.setName("RPK"); // NOI18N
        RPK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RPKKeyPressed(evt);
            }
        });
        scrollPane3.setViewportView(RPK);

        FormInput1.add(scrollPane3);
        scrollPane3.setBounds(200, 80, 255, 42);

        jLabel71.setText("Riwayat Penyakit Keluarga :");
        jLabel71.setName("jLabel71"); // NOI18N
        FormInput1.add(jLabel71);
        jLabel71.setBounds(10, 80, 180, 23);

        scrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane4.setName("scrollPane4"); // NOI18N

        RPO.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        RPO.setColumns(20);
        RPO.setRows(5);
        RPO.setName("RPO"); // NOI18N
        RPO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RPOKeyPressed(evt);
            }
        });
        scrollPane4.setViewportView(RPO);

        FormInput1.add(scrollPane4);
        scrollPane4.setBounds(190, 130, 263, 42);

        scrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane5.setName("scrollPane5"); // NOI18N

        KetFisik.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        KetFisik.setColumns(20);
        KetFisik.setRows(5);
        KetFisik.setName("KetFisik"); // NOI18N
        KetFisik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KetFisikKeyPressed(evt);
            }
        });
        scrollPane5.setViewportView(KetFisik);

        FormInput1.add(scrollPane5);
        scrollPane5.setBounds(530, 260, 340, 113);

        jLabel72.setText("GCS(E,V,M) :");
        jLabel72.setName("jLabel72"); // NOI18N
        FormInput1.add(jLabel72);
        jLabel72.setBounds(500, 200, 70, 23);

        GCS.setFocusTraversalPolicyProvider(true);
        GCS.setName("GCS"); // NOI18N
        GCS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GCSKeyPressed(evt);
            }
        });
        FormInput1.add(GCS);
        GCS.setBounds(580, 200, 60, 23);

        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel94.setText("II. PEMERIKSAAN FISIK");
        jLabel94.setName("jLabel94"); // NOI18N
        FormInput1.add(jLabel94);
        jLabel94.setBounds(20, 180, 180, 23);

        jSeparator1.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator1.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator1.setName("jSeparator1"); // NOI18N
        FormInput1.add(jSeparator1);
        jSeparator1.setBounds(10, 10, 880, 1);

        jLabel74.setText("Keluhan Utama :");
        jLabel74.setName("jLabel74"); // NOI18N
        FormInput1.add(jLabel74);
        jLabel74.setBounds(10, 30, 125, 23);

        scrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane7.setName("scrollPane7"); // NOI18N

        RPS.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        RPS.setColumns(20);
        RPS.setRows(5);
        RPS.setName("RPS"); // NOI18N
        RPS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RPSKeyPressed(evt);
            }
        });
        scrollPane7.setViewportView(RPS);

        FormInput1.add(scrollPane7);
        scrollPane7.setBounds(610, 30, 260, 43);

        jSeparator12.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator12.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator12.setName("jSeparator12"); // NOI18N
        FormInput1.add(jSeparator12);
        jSeparator12.setBounds(10, 180, 880, 1);

        jLabel39.setText("Kesadaran :");
        jLabel39.setName("jLabel39"); // NOI18N
        FormInput1.add(jLabel39);
        jLabel39.setBounds(280, 200, 70, 23);

        Keadaan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sehat", "Sakit Ringan", "Sakit Sedang", "Sakit Berat" }));
        Keadaan.setName("Keadaan"); // NOI18N
        Keadaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeadaanKeyPressed(evt);
            }
        });
        FormInput1.add(Keadaan);
        Keadaan.setBounds(150, 200, 118, 23);

        jLabel40.setText("Kepala :");
        jLabel40.setName("jLabel40"); // NOI18N
        FormInput1.add(jLabel40);
        jLabel40.setBounds(10, 260, 127, 23);

        Kesadaran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Compos Mentis", "Apatis", "Somnolence", "Sopor", "Coma" }));
        Kesadaran.setName("Kesadaran"); // NOI18N
        Kesadaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KesadaranKeyPressed(evt);
            }
        });
        FormInput1.add(Kesadaran);
        Kesadaran.setBounds(350, 200, 130, 23);

        jLabel41.setText("Keadaan Umum :");
        jLabel41.setName("jLabel41"); // NOI18N
        FormInput1.add(jLabel41);
        jLabel41.setBounds(10, 200, 127, 23);

        jLabel75.setText("SpO2 :");
        jLabel75.setName("jLabel75"); // NOI18N
        FormInput1.add(jLabel75);
        jLabel75.setBounds(610, 230, 40, 23);

        SPO.setFocusTraversalPolicyProvider(true);
        SPO.setName("SPO"); // NOI18N
        SPO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SPOKeyPressed(evt);
            }
        });
        FormInput1.add(SPO);
        SPO.setBounds(660, 230, 45, 23);

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("%");
        jLabel35.setName("jLabel35"); // NOI18N
        FormInput1.add(jLabel35);
        jLabel35.setBounds(710, 230, 30, 23);

        Kepala.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Abnormal", "Tidak Diperiksa" }));
        Kepala.setName("Kepala"); // NOI18N
        Kepala.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KepalaKeyPressed(evt);
            }
        });
        FormInput1.add(Kepala);
        Kepala.setBounds(150, 260, 128, 23);

        jLabel44.setText("Gigi & Mulut :");
        jLabel44.setName("jLabel44"); // NOI18N
        FormInput1.add(jLabel44);
        jLabel44.setBounds(10, 320, 127, 23);

        Gigi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Abnormal", "Tidak Diperiksa" }));
        Gigi.setName("Gigi"); // NOI18N
        Gigi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GigiKeyPressed(evt);
            }
        });
        FormInput1.add(Gigi);
        Gigi.setBounds(150, 320, 128, 23);

        jLabel45.setText("Leher :");
        jLabel45.setName("jLabel45"); // NOI18N
        FormInput1.add(jLabel45);
        jLabel45.setBounds(10, 350, 127, 23);

        Leher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Abnormal", "Tidak Diperiksa" }));
        Leher.setName("Leher"); // NOI18N
        Leher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LeherKeyPressed(evt);
            }
        });
        FormInput1.add(Leher);
        Leher.setBounds(150, 350, 128, 23);

        jLabel46.setText("Thoraks :");
        jLabel46.setName("jLabel46"); // NOI18N
        FormInput1.add(jLabel46);
        jLabel46.setBounds(280, 260, 95, 23);

        Thoraks.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Abnormal", "Tidak Diperiksa" }));
        Thoraks.setName("Thoraks"); // NOI18N
        Thoraks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ThoraksKeyPressed(evt);
            }
        });
        FormInput1.add(Thoraks);
        Thoraks.setBounds(380, 260, 128, 23);

        jLabel49.setText("Abdomen :");
        jLabel49.setName("jLabel49"); // NOI18N
        FormInput1.add(jLabel49);
        jLabel49.setBounds(280, 290, 95, 23);

        Abdomen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Abnormal", "Tidak Diperiksa" }));
        Abdomen.setName("Abdomen"); // NOI18N
        Abdomen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AbdomenKeyPressed(evt);
            }
        });
        FormInput1.add(Abdomen);
        Abdomen.setBounds(380, 290, 128, 23);

        jLabel50.setText("Genital & Anus :");
        jLabel50.setName("jLabel50"); // NOI18N
        FormInput1.add(jLabel50);
        jLabel50.setBounds(280, 320, 95, 23);

        Genital.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Abnormal", "Tidak Diperiksa" }));
        Genital.setName("Genital"); // NOI18N
        Genital.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GenitalKeyPressed(evt);
            }
        });
        FormInput1.add(Genital);
        Genital.setBounds(380, 320, 128, 23);

        jLabel51.setText("Ekstremitas :");
        jLabel51.setName("jLabel51"); // NOI18N
        FormInput1.add(jLabel51);
        jLabel51.setBounds(280, 350, 95, 23);

        Ekstremitas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Abnormal", "Tidak Diperiksa" }));
        Ekstremitas.setName("Ekstremitas"); // NOI18N
        Ekstremitas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EkstremitasKeyPressed(evt);
            }
        });
        FormInput1.add(Ekstremitas);
        Ekstremitas.setBounds(380, 350, 128, 23);

        jSeparator13.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator13.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator13.setName("jSeparator13"); // NOI18N
        FormInput1.add(jSeparator13);
        jSeparator13.setBounds(10, 380, 880, 1);

        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel99.setText("I. RIWAYAT KESEHATAN");
        jLabel99.setName("jLabel99"); // NOI18N
        FormInput1.add(jLabel99);
        jLabel99.setBounds(20, 10, 180, 23);

        PanelWall.setBackground(new java.awt.Color(29, 29, 29));
        PanelWall.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/semua.png"))); // NOI18N
        PanelWall.setBackgroundImageType(usu.widget.constan.BackgroundConstan.BACKGROUND_IMAGE_STRECT);
        PanelWall.setPreferredSize(new java.awt.Dimension(200, 200));
        PanelWall.setRound(false);
        PanelWall.setWarna(new java.awt.Color(110, 110, 110));
        PanelWall.setLayout(null);
        FormInput1.add(PanelWall);
        PanelWall.setBounds(60, 400, 809, 300);

        scrollPane8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane8.setName("scrollPane8"); // NOI18N

        KetLokalis.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        KetLokalis.setColumns(20);
        KetLokalis.setRows(5);
        KetLokalis.setName("KetLokalis"); // NOI18N
        KetLokalis.setPreferredSize(new java.awt.Dimension(182, 92));
        KetLokalis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KetLokalisKeyPressed(evt);
            }
        });
        scrollPane8.setViewportView(KetLokalis);

        FormInput1.add(scrollPane8);
        scrollPane8.setBounds(60, 720, 810, 83);

        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText("Keterangan :");
        jLabel79.setName("jLabel79"); // NOI18N
        FormInput1.add(jLabel79);
        jLabel79.setBounds(60, 700, 100, 23);

        jSeparator14.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator14.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator14.setName("jSeparator14"); // NOI18N
        FormInput1.add(jSeparator14);
        jSeparator14.setBounds(10, 810, 880, 1);

        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel100.setText("III. STATUS LOKALIS");
        jLabel100.setName("jLabel100"); // NOI18N
        FormInput1.add(jLabel100);
        jLabel100.setBounds(20, 380, 180, 23);

        scrollPane9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane9.setName("scrollPane9"); // NOI18N

        EKG.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        EKG.setColumns(20);
        EKG.setRows(5);
        EKG.setName("EKG"); // NOI18N
        EKG.setPreferredSize(new java.awt.Dimension(102, 52));
        EKG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EKGKeyPressed(evt);
            }
        });
        scrollPane9.setViewportView(EKG);

        FormInput1.add(scrollPane9);
        scrollPane9.setBounds(60, 850, 260, 63);

        jSeparator15.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator15.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator15.setName("jSeparator15"); // NOI18N
        FormInput1.add(jSeparator15);
        jSeparator15.setBounds(10, 920, 880, 1);

        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel101.setText("IV. PEMERIKSAAN PENUNJANG");
        jLabel101.setName("jLabel101"); // NOI18N
        FormInput1.add(jLabel101);
        jLabel101.setBounds(20, 810, 190, 23);

        scrollPane12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane12.setName("scrollPane12"); // NOI18N

        Diagnosis.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Diagnosis.setColumns(20);
        Diagnosis.setRows(3);
        Diagnosis.setName("Diagnosis"); // NOI18N
        Diagnosis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DiagnosisKeyPressed(evt);
            }
        });
        scrollPane12.setViewportView(Diagnosis);

        FormInput1.add(scrollPane12);
        scrollPane12.setBounds(60, 940, 810, 43);

        jSeparator16.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator16.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator16.setName("jSeparator16"); // NOI18N
        FormInput1.add(jSeparator16);
        jSeparator16.setBounds(10, 990, 880, 1);

        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel102.setText("V. DIAGNOSIS/ASESMEN");
        jLabel102.setName("jLabel102"); // NOI18N
        FormInput1.add(jLabel102);
        jLabel102.setBounds(20, 920, 190, 23);

        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel103.setText("VI. TATALAKSANA");
        jLabel103.setName("jLabel103"); // NOI18N
        FormInput1.add(jLabel103);
        jLabel103.setBounds(20, 990, 190, 23);

        jLabel42.setText("Mata :");
        jLabel42.setName("jLabel42"); // NOI18N
        FormInput1.add(jLabel42);
        jLabel42.setBounds(10, 290, 127, 23);

        Mata.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Abnormal", "Tidak Diperiksa" }));
        Mata.setName("Mata"); // NOI18N
        Mata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MataKeyPressed(evt);
            }
        });
        FormInput1.add(Mata);
        Mata.setBounds(150, 290, 128, 23);

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("EKG :");
        jLabel80.setName("jLabel80"); // NOI18N
        FormInput1.add(jLabel80);
        jLabel80.setBounds(60, 830, 150, 23);

        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("Radiologi :");
        jLabel81.setName("jLabel81"); // NOI18N
        FormInput1.add(jLabel81);
        jLabel81.setBounds(330, 830, 150, 23);

        scrollPane10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane10.setName("scrollPane10"); // NOI18N

        Radiologi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Radiologi.setColumns(20);
        Radiologi.setRows(5);
        Radiologi.setName("Radiologi"); // NOI18N
        Radiologi.setPreferredSize(new java.awt.Dimension(102, 52));
        Radiologi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RadiologiKeyPressed(evt);
            }
        });
        scrollPane10.setViewportView(Radiologi);

        FormInput1.add(scrollPane10);
        scrollPane10.setBounds(330, 850, 260, 63);

        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel82.setText("Laborat :");
        jLabel82.setName("jLabel82"); // NOI18N
        FormInput1.add(jLabel82);
        jLabel82.setBounds(610, 830, 150, 23);

        scrollPane11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane11.setName("scrollPane11"); // NOI18N

        Laborat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Laborat.setColumns(20);
        Laborat.setRows(5);
        Laborat.setName("Laborat"); // NOI18N
        Laborat.setPreferredSize(new java.awt.Dimension(102, 52));
        Laborat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LaboratKeyPressed(evt);
            }
        });
        scrollPane11.setViewportView(Laborat);

        FormInput1.add(scrollPane11);
        scrollPane11.setBounds(610, 850, 260, 63);

        scrollPane14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane14.setName("scrollPane14"); // NOI18N

        Tatalaksana.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Tatalaksana.setColumns(20);
        Tatalaksana.setRows(3);
        Tatalaksana.setName("Tatalaksana"); // NOI18N
        Tatalaksana.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TatalaksanaKeyPressed(evt);
            }
        });
        scrollPane14.setViewportView(Tatalaksana);

        FormInput1.add(scrollPane14);
        scrollPane14.setBounds(60, 1020, 810, 200);

        Skalanyeri.setHighlighter(null);
        Skalanyeri.setName("Skalanyeri"); // NOI18N
        Skalanyeri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalanyeriKeyPressed(evt);
            }
        });
        FormInput1.add(Skalanyeri);
        Skalanyeri.setBounds(800, 230, 55, 23);

        jLabel48.setText("Skor : 1 - 10");
        jLabel48.setName("jLabel48"); // NOI18N
        FormInput1.add(jLabel48);
        jLabel48.setBounds(840, 230, 79, 23);

        jLabel54.setText("Skala nyeri :");
        jLabel54.setName("jLabel54"); // NOI18N
        FormInput1.add(jLabel54);
        jLabel54.setBounds(720, 230, 79, 23);

        scrollInput.setViewportView(FormInput1);

        TabTriase.addTab("Awal Medis IGD", scrollInput);

        FormTriase.add(TabTriase, java.awt.BorderLayout.CENTER);

        ScrollTriase.setViewportView(FormTriase);

        TabPilihan.addTab("Input Triase", ScrollTriase);

        internalFrame4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame4.setName("internalFrame4"); // NOI18N
        internalFrame4.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);
        Scroll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScrollMouseClicked(evt);
            }
        });

        tbTriase.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbTriase.setName("tbTriase"); // NOI18N
        tbTriase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTriaseMouseClicked(evt);
            }
        });
        tbTriase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbTriaseKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbTriaseKeyReleased(evt);
            }
        });
        Scroll.setViewportView(tbTriase);

        internalFrame4.add(Scroll, java.awt.BorderLayout.CENTER);

        panelGlass9.setName("panelGlass9"); // NOI18N
        panelGlass9.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel19.setText("Tgl.Triase :");
        jLabel19.setName("jLabel19"); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(65, 23));
        panelGlass9.add(jLabel19);

        DTPCari1.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09-05-2026" }));
        DTPCari1.setDisplayFormat("dd-MM-yyyy");
        DTPCari1.setName("DTPCari1"); // NOI18N
        DTPCari1.setOpaque(false);
        DTPCari1.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass9.add(DTPCari1);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("s.d.");
        jLabel21.setName("jLabel21"); // NOI18N
        jLabel21.setPreferredSize(new java.awt.Dimension(23, 23));
        panelGlass9.add(jLabel21);

        DTPCari2.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09-05-2026" }));
        DTPCari2.setDisplayFormat("dd-MM-yyyy");
        DTPCari2.setName("DTPCari2"); // NOI18N
        DTPCari2.setOpaque(false);
        DTPCari2.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass9.add(DTPCari2);

        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass9.add(jLabel6);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(205, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelGlass9.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('3');
        BtnCari.setToolTipText("Alt+3");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelGlass9.add(BtnCari);

        jLabel7.setText("Record :");
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(65, 23));
        panelGlass9.add(jLabel7);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(50, 23));
        panelGlass9.add(LCount);

        internalFrame4.add(panelGlass9, java.awt.BorderLayout.PAGE_END);

        PanelAccor.setBackground(new java.awt.Color(255, 255, 255));
        PanelAccor.setName("PanelAccor"); // NOI18N
        PanelAccor.setPreferredSize(new java.awt.Dimension(470, 43));
        PanelAccor.setLayout(new java.awt.BorderLayout(1, 1));

        ChkAccor.setBackground(new java.awt.Color(255, 250, 248));
        ChkAccor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/kiri.png"))); // NOI18N
        ChkAccor.setSelected(true);
        ChkAccor.setFocusable(false);
        ChkAccor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChkAccor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ChkAccor.setName("ChkAccor"); // NOI18N
        ChkAccor.setPreferredSize(new java.awt.Dimension(15, 20));
        ChkAccor.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/kiri.png"))); // NOI18N
        ChkAccor.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/kanan.png"))); // NOI18N
        ChkAccor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/kanan.png"))); // NOI18N
        ChkAccor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkAccorActionPerformed(evt);
            }
        });
        PanelAccor.add(ChkAccor, java.awt.BorderLayout.WEST);

        FormMenu.setBackground(new java.awt.Color(255, 255, 255));
        FormMenu.setBorder(null);
        FormMenu.setName("FormMenu"); // NOI18N
        FormMenu.setPreferredSize(new java.awt.Dimension(115, 43));
        FormMenu.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 9));

        jLabel34.setText("Pasien :");
        jLabel34.setName("jLabel34"); // NOI18N
        jLabel34.setPreferredSize(new java.awt.Dimension(55, 23));
        FormMenu.add(jLabel34);

        TNoRM1.setEditable(false);
        TNoRM1.setHighlighter(null);
        TNoRM1.setName("TNoRM1"); // NOI18N
        TNoRM1.setPreferredSize(new java.awt.Dimension(100, 23));
        FormMenu.add(TNoRM1);

        TPasien1.setEditable(false);
        TPasien1.setBackground(new java.awt.Color(245, 250, 240));
        TPasien1.setHighlighter(null);
        TPasien1.setName("TPasien1"); // NOI18N
        TPasien1.setPreferredSize(new java.awt.Dimension(250, 23));
        FormMenu.add(TPasien1);

        BtnPrint1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/item (copy).png"))); // NOI18N
        BtnPrint1.setMnemonic('T');
        BtnPrint1.setToolTipText("Alt+T");
        BtnPrint1.setName("BtnPrint1"); // NOI18N
        BtnPrint1.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnPrint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrint1ActionPerformed(evt);
            }
        });
        FormMenu.add(BtnPrint1);

        PanelAccor.add(FormMenu, java.awt.BorderLayout.NORTH);

        ScrollHTML.setBorder(null);
        ScrollHTML.setName("ScrollHTML"); // NOI18N
        ScrollHTML.setOpaque(true);
        ScrollHTML.setPreferredSize(new java.awt.Dimension(470, 16));

        LoadHTML.setBorder(null);
        LoadHTML.setName("LoadHTML"); // NOI18N
        ScrollHTML.setViewportView(LoadHTML);

        PanelAccor.add(ScrollHTML, java.awt.BorderLayout.CENTER);

        internalFrame4.add(PanelAccor, java.awt.BorderLayout.EAST);

        TabPilihan.addTab("Data Triase", internalFrame4);

        internalFrame15.setBorder(null);
        internalFrame15.setName("internalFrame15"); // NOI18N
        internalFrame15.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll9.setName("Scroll9"); // NOI18N
        Scroll9.setOpaque(true);
        Scroll9.setPreferredSize(new java.awt.Dimension(452, 200));

        tbAwalMedisIGD.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbAwalMedisIGD.setName("tbAwalMedisIGD"); // NOI18N
        tbAwalMedisIGD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAwalMedisIGDMouseClicked(evt);
            }
        });
        tbAwalMedisIGD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbAwalMedisIGDKeyPressed(evt);
            }
        });
        Scroll9.setViewportView(tbAwalMedisIGD);

        internalFrame15.add(Scroll9, java.awt.BorderLayout.CENTER);

        panelGlass11.setName("panelGlass11"); // NOI18N
        panelGlass11.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel77.setText("Tgl.Asuhan :");
        jLabel77.setName("jLabel77"); // NOI18N
        jLabel77.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass11.add(jLabel77);

        DTPCari5.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09-05-2026" }));
        DTPCari5.setDisplayFormat("dd-MM-yyyy");
        DTPCari5.setName("DTPCari5"); // NOI18N
        DTPCari5.setOpaque(false);
        DTPCari5.setPreferredSize(new java.awt.Dimension(90, 23));
        DTPCari5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DTPCari5ActionPerformed(evt);
            }
        });
        panelGlass11.add(DTPCari5);

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("s.d.");
        jLabel78.setName("jLabel78"); // NOI18N
        jLabel78.setPreferredSize(new java.awt.Dimension(23, 23));
        panelGlass11.add(jLabel78);

        DTPCari6.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09-05-2026" }));
        DTPCari6.setDisplayFormat("dd-MM-yyyy");
        DTPCari6.setName("DTPCari6"); // NOI18N
        DTPCari6.setOpaque(false);
        DTPCari6.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass11.add(DTPCari6);

        jLabel83.setText("Key Word :");
        jLabel83.setName("jLabel83"); // NOI18N
        jLabel83.setPreferredSize(new java.awt.Dimension(80, 23));
        panelGlass11.add(jLabel83);

        TCari2.setName("TCari2"); // NOI18N
        TCari2.setPreferredSize(new java.awt.Dimension(195, 23));
        TCari2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCari2KeyPressed(evt);
            }
        });
        panelGlass11.add(TCari2);

        BtnCari2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari2.setMnemonic('3');
        BtnCari2.setToolTipText("Alt+3");
        BtnCari2.setName("BtnCari2"); // NOI18N
        BtnCari2.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCari2ActionPerformed(evt);
            }
        });
        BtnCari2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCari2KeyPressed(evt);
            }
        });
        panelGlass11.add(BtnCari2);

        jLabel84.setText("Record :");
        jLabel84.setName("jLabel84"); // NOI18N
        jLabel84.setPreferredSize(new java.awt.Dimension(60, 23));
        panelGlass11.add(jLabel84);

        LCount2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount2.setText("0");
        LCount2.setName("LCount2"); // NOI18N
        LCount2.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass11.add(LCount2);

        internalFrame15.add(panelGlass11, java.awt.BorderLayout.PAGE_END);

        TabPilihan.addTab("Data Penilaian IGD", internalFrame15);

        TabPilihan.setSelectedIndex(1);

        internalFrame1.add(TabPilihan, java.awt.BorderLayout.CENTER);

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(44, 54));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpan.setMnemonic('S');
        BtnSimpan.setText("Simpan");
        BtnSimpan.setToolTipText("Alt+S");
        BtnSimpan.setName("BtnSimpan"); // NOI18N
        BtnSimpan.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });
        BtnSimpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSimpanKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnSimpan);

        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Cancel-2-16x16.png"))); // NOI18N
        BtnBatal.setMnemonic('B');
        BtnBatal.setText("Baru");
        BtnBatal.setToolTipText("Alt+B");
        BtnBatal.setName("BtnBatal"); // NOI18N
        BtnBatal.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });
        BtnBatal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnBatalKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnBatal);

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnHapus.setMnemonic('H');
        BtnHapus.setText("Hapus");
        BtnHapus.setToolTipText("Alt+H");
        BtnHapus.setName("BtnHapus"); // NOI18N
        BtnHapus.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });
        BtnHapus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnHapusKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnHapus);

        BtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/inventaris.png"))); // NOI18N
        BtnEdit.setMnemonic('G');
        BtnEdit.setText("Ganti");
        BtnEdit.setToolTipText("Alt+G");
        BtnEdit.setName("BtnEdit"); // NOI18N
        BtnEdit.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });
        BtnEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnEditKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnEdit);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnPrint);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setText("Semua");
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnAll);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnKeluar);

        internalFrame1.add(panelGlass8, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        if(TNoRw.getText().trim().equals("")||TPasien.getText().trim().equals("")){
            Valid.textKosong(TNoRw,"Pasien");
        }else if(KdKasus.getText().trim().equals("")||NmKasus.getText().trim().equals("")){
            Valid.textKosong(btnKasus,"Macam Kasus");
        }else if(KeteranganKedatangan.equals("")){
            Valid.textKosong(btnKasus,"Keterangan");
        }else if(TNoRM.getText().trim().equals("")){
            Valid.textKosong(TNoRw,"Nama Pasien");
        }else{
            //triase 
            if(TabTriase.getSelectedIndex()==0){
                if(PrimerKeluhanUtama.getText().trim().equals("")){
                    Valid.textKosong(PrimerKeluhanUtama,"Keluhan Utama");
                }else if(PrimerSuhu.getText().trim().equals("")){
                    Valid.textKosong(PrimerSuhu,"Suhu");
                }else if(PrimerNyeri.getText().trim().equals("")){
                    Valid.textKosong(PrimerNyeri,"Nyeri");
                }else if(PrimerTensi.getText().trim().equals("")){
                    Valid.textKosong(PrimerTensi,"Tensi");
                }else if(PrimerNadi.getText().trim().equals("")){
                    Valid.textKosong(PrimerNadi,"Nadi");
                }else if(PrimerSaturasi.getText().trim().equals("")){
                    Valid.textKosong(PrimerSaturasi,"Saturasi O²");
                }else if(PrimerRespirasi.getText().trim().equals("")){
                    Valid.textKosong(PrimerRespirasi,"Respirasi");
                }else if(PrimerKodePetugas.getText().trim().equals("")||PrimerNamaPetugas.getText().trim().equals("")){
                    Valid.textKosong(btnPrimerPetugas,"Dokter/Petugas Triase");
                }else{
                    
                    // [PERBAIKAN] Logika Checkbox ESI 1 (agar jika tidak dicentang maka bernilai kosong)
                    String esi1 = cbPrioritas1.isSelected() ? cbPrioritas1.getText() : "";
                    
                    String esi2 ="";
                    String esi3 = "";
                    String esi4 ="";
                    String esi5 ="";
                    
                    if(cbPrioritas2a.isSelected()){
                        esi2= cbPrioritas2a.getText();
                    }else if(cbPrioritas2b.isSelected()){
                        esi2= cbPrioritas2b.getText();
                    }else if(cbPrioritas2c.isSelected()){
                        esi2= cbPrioritas2c.getText();
                    }
                    
                   
                    
                    if(cbPrioritas543.getSelectedItem().equals("-")){
                        cbPrioritas543.getSelectedItem().toString();
                    }else if(cbPrioritas543.getSelectedItem().equals("TIDAK ADA")){
                        esi5 = cbPrioritas543.getSelectedItem().toString();
                    }else if(cbPrioritas543.getSelectedItem().equals("SATU")){
                        esi4 = cbPrioritas543.getSelectedItem().toString();
                    }else if(cbPrioritas543.getSelectedItem().equals("BANYAK (>2)")){
                    if (cbPrioritas3.isSelected()) {
                            esi3 = cbPrioritas543.getSelectedItem().toString() + " - " + cbPrioritas3.getText();
                        } else if (cbPrioritas3tidak.isSelected()) {
                            esi3 = cbPrioritas543.getSelectedItem().toString() + " - " + cbPrioritas3tidak.getText();
                        } else {
                            esi3 = cbPrioritas543.getSelectedItem().toString();
                        }
                        
                    }
                    
                    param1="Tidak";
                    param2="Tidak";
                    param3="Tidak";
                    param4="Tidak";
                    
                    if(cekYa1.isSelected()==true){
                        param1="Ya";
                    }if(cekYa2.isSelected()==true){
                        param2="Ya";
                    }if(cekYa3.isSelected()==true){
                        param3="Ya";
                    }if(cekYa4.isSelected()==true){
                        param4="Ya";
                    }
                    getNIlaiisolasi();
                    getPsikologi();

                 
                    if(Sequel.menyimpantf("data_triase_igd", "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?", "No.Rawat", 33, new String[]{
                        TNoRw.getText(), Valid.SetTgl(TanggalKunjungan.getSelectedItem() + "") + " " + TanggalKunjungan.getSelectedItem().toString().substring(11, 19),
                        CaraMasuk.getSelectedItem().toString(), Transportasi.getSelectedItem().toString(), AlasanKedatangan.getSelectedItem().toString(),
                        KeteranganKedatangan.getText(), KdKasus.getText(), PrimerTensi.getText(), PrimerNadi.getText(), PrimerRespirasi.getText(), PrimerSuhu.getText(),
                        PrimerSaturasi.getText(), PrimerNyeri.getText(),PrimerKeluhanUtama.getText(),PrimerKubutuhanKusus.getSelectedItem().toString(),PrimerCatatan.getText(),
                        esi1, esi2, esi3, esi4, esi5, param1, param2, param3, param4, getIsolasi, getPsikologi, comboBox1.getSelectedItem().toString(),
                        lokasinyeri.getText(), durasinyeri.getText(), frekuensinyeri.getText(), gambarannyeri.getText(),PrimerKodePetugas.getText()
                    })==true){
                        if(PrimerResusitasi.isSelected()==true){
                            keputusan="Ruang Resusitasi";
                        }else if(PrimerKritis.isSelected()==true){
                            keputusan="Ruang Kritis";
                        }else if(SekunderZonaKuning1.isSelected()==true){
                            keputusan="Zona Kuning";
                        }else if(SekunderZonaHijau1.isSelected()==true){
                            keputusan="Zona Hijau";
                        }
                        Sequel.menyimpantf2("data_triase_igdprimer", "?,?,?,?,?,?,?", 7, new String[]{
                            TNoRw.getText(), PrimerKeluhanUtama.getText(), PrimerKubutuhanKusus.getSelectedItem().toString(), PrimerCatatan.getText(), keputusan,
                            Valid.SetTgl(PrimerTanggalTriase.getSelectedItem() + "") + " " + PrimerTanggalTriase.getSelectedItem().toString().substring(11, 19),
                            PrimerKodePetugas.getText()
                        });
                        
                        tampil();
                    }

                    emptTeks();
                }
            //assesmen dokter
            }else if (TabTriase.getSelectedIndex() == 1) {
                if (TNoRM.getText().trim().equals("")) {
                    Valid.textKosong(TNoRw, "Nama Pasien");
                } else if (KeluhanUtama.getText().trim().equals("")) {
                    Valid.textKosong(KeluhanUtama, "Keluhan Utama");
                } else if (RPS.getText().trim().equals("")) {
                    Valid.textKosong(RPS, "Riwayat Penyakit Sekarang");
                } else if (RPK.getText().trim().equals("")) {
                    Valid.textKosong(RPK, "Riwayat Penyakit Keluarga");
                } else if (RPD.getText().trim().equals("")) {
                    Valid.textKosong(RPD, "Riwayat Penyakit Dahulu");
                } else if (RPO.getText().trim().equals("")) {
                    Valid.textKosong(RPO, "Riwayat Pengunaan obat");
                } else {

                    if (Sequel.menyimpantf("penilaian_medis_igd", "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?", "No.Rawat", 36, new String[]{
                        TNoRw.getText(), Valid.SetTgl(TanggalKunjungan.getSelectedItem() + "") + " " + TanggalKunjungan.getSelectedItem().toString().substring(11, 19), PrimerKodePetugas.getText(), Anamnesis.getSelectedItem().toString(), Hubungan.getText(),
                        KeluhanUtama.getText(), RPS.getText(), RPD.getText(), RPK.getText(), RPO.getText(), Alergi.getText(), Keadaan.getSelectedItem().toString(), GCS.getText(), Kesadaran.getSelectedItem().toString(), TD.getText(),
                        Nadi.getText(), RR.getText(), Suhu.getText(), SPO.getText(), BB.getText(), TB.getText(), Kepala.getSelectedItem().toString(), Mata.getSelectedItem().toString(), Gigi.getSelectedItem().toString(), Leher.getSelectedItem().toString(),
                        Thoraks.getSelectedItem().toString(), Abdomen.getSelectedItem().toString(), Genital.getSelectedItem().toString(), Ekstremitas.getSelectedItem().toString(), KetFisik.getText(), KetLokalis.getText(), EKG.getText(),
                        Radiologi.getText(), Laborat.getText(), Diagnosis.getText(), Tatalaksana.getText()
                    }) == true) {
                    tampilawalmedis();
                    }
                    emptTeks();
                    //}
                }
            }
        }

        
    
}//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if(TabTriase.getSelectedIndex()==1){
            Valid.pindah(evt,btnPrimerPetugas,BtnBatal);
      }//else if(TabTriase.getSelectedIndex()==2){
//            Valid.pindah(evt,btnSekunderPetugas,BtnBatal);
//        }
}//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        emptTeks();
}//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBatalKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            emptTeks();
        }else{Valid.pindah(evt, BtnSimpan, BtnHapus);}
}//GEN-LAST:event_BtnBatalKeyPressed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis...!!!!");
            TCari.requestFocus();
        }else{
            if(tbTriase.getSelectedRow()!= -1){
                Sequel.meghapus("data_triase_igd","no_rawat",tbTriase.getValueAt(tbTriase.getSelectedRow(),0).toString());
                Sequel.meghapus("data_triase_igdprimer","no_rawat",tbTriase.getValueAt(tbTriase.getSelectedRow(),0).toString());
                Sequel.meghapus("data_triase_igdsekunder","no_rawat",tbTriase.getValueAt(tbTriase.getSelectedRow(),0).toString());
                Sequel.meghapus("data_triase_igddetail_skala1","no_rawat",tbTriase.getValueAt(tbTriase.getSelectedRow(),0).toString());
                Sequel.meghapus("data_triase_igddetail_skala2","no_rawat",tbTriase.getValueAt(tbTriase.getSelectedRow(),0).toString());
                Sequel.meghapus("data_triase_igddetail_skala3","no_rawat",tbTriase.getValueAt(tbTriase.getSelectedRow(),0).toString());
                Sequel.meghapus("data_triase_igddetail_skala4","no_rawat",tbTriase.getValueAt(tbTriase.getSelectedRow(),0).toString());
                Sequel.meghapus("data_triase_igddetail_skala5","no_rawat",tbTriase.getValueAt(tbTriase.getSelectedRow(),0).toString());
                tampil();
                TNoRM1.setText("");
                TPasien1.setText("");
                LoadHTML.setText("");
                ChkAccor.setSelected(false);
                isMenu();
            }else{
                JOptionPane.showMessageDialog(null,"Maaf, silahkan pilih data yang mau dihapus terlebih dahulu ...!!!!");
            }
        }
}//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnHapusActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnBatal, BtnEdit);
        }
}//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        if(TNoRw.getText().trim().equals("")||TPasien.getText().trim().equals("")){
            Valid.textKosong(TNoRw,"Pasien");
        }else if(KdKasus.getText().trim().equals("")||NmKasus.getText().trim().equals("")){
            Valid.textKosong(btnKasus,"Macam Kasus");
        }else if(KeteranganKedatangan.equals("")){
            Valid.textKosong(btnKasus,"Keterangan");
        }else{
               if (TabTriase.getSelectedIndex() == 0) {
                if (PrimerKeluhanUtama.getText().trim().equals("")) {
                    Valid.textKosong(PrimerKeluhanUtama, "Keluhan Utama");
                } else if (PrimerSuhu.getText().trim().equals("")) {
                    Valid.textKosong(PrimerSuhu, "Suhu");
                } else if (PrimerNyeri.getText().trim().equals("")) {
                    Valid.textKosong(PrimerNyeri, "Nyeri");
                } else if (PrimerTensi.getText().trim().equals("")) {
                    Valid.textKosong(PrimerTensi, "Tensi");
                } else if (PrimerNadi.getText().trim().equals("")) {
                    Valid.textKosong(PrimerNadi, "Nadi");
                } else if (PrimerSaturasi.getText().trim().equals("")) {
                    Valid.textKosong(PrimerSaturasi, "Saturasi O²");
                } else if (PrimerRespirasi.getText().trim().equals("")) {
                    Valid.textKosong(PrimerRespirasi, "Respirasi");
                } else {
                    String esi1 = cbPrioritas1.isSelected() ? cbPrioritas1.getText() : "";
                    String esi2 = "";
                    String esi3 = "";
                    String esi4 = "";
                    String esi5 = "";
                    if (cbPrioritas2a.isSelected()) {
                        esi2 = cbPrioritas2a.getText();
                    } else if (cbPrioritas2b.isSelected()) {
                        esi2 = cbPrioritas2b.getText();
                    } else if (cbPrioritas2c.isSelected()) {
                        esi2 = cbPrioritas2c.getText();
                    }

                    if(cbPrioritas543.getSelectedItem().equals("-")){
                        cbPrioritas543.getSelectedItem().toString();
                    }else if(cbPrioritas543.getSelectedItem().equals("TIDAK ADA")){
                        esi5 = cbPrioritas543.getSelectedItem().toString();
                    }else if(cbPrioritas543.getSelectedItem().equals("SATU")){
                        esi4 = cbPrioritas543.getSelectedItem().toString();
                    }else if(cbPrioritas543.getSelectedItem().equals("BANYAK (>2)")){
                    if (cbPrioritas3.isSelected()) {
                            esi3 = cbPrioritas543.getSelectedItem().toString() + " - " + cbPrioritas3.getText();
                        } else if (cbPrioritas3tidak.isSelected()) {
                            esi3 = cbPrioritas543.getSelectedItem().toString() + " - " + cbPrioritas3tidak.getText();
                        } else {
                            esi3 = cbPrioritas543.getSelectedItem().toString();
                        }
                        
                    }
                    

                    param1 = "Tidak";
                    param2 = "Tidak";
                    param3 = "Tidak";
                    param4 = "Tidak";

                    if (cekYa1.isSelected() == true) {
                        param1 = "Ya";
                    } if (cekYa2.isSelected() == true) {
                        param2 = "Ya";
                    } if (cekYa3.isSelected() == true) {
                        param3 = "Ya";
                    } if (cekYa4.isSelected() == true) {
                        param4 = "Ya";
                    }
                    getNIlaiisolasi();
                    getPsikologi();
                    
                    if (PrimerResusitasi.isSelected() == true) {
                        keputusan = "Ruang Resusitasi";
                    } else if (PrimerKritis.isSelected() == true) {
                        keputusan = "Ruang Kritis";
                    }
                    if (SekunderZonaKuning1.isSelected() == true) {
                        keputusan = "Zona Kuning";
                    } else if (SekunderZonaHijau1.isSelected() == true) {
                        keputusan = "Zona Hijau";
                    }
                    if (Sequel.mengedittf("data_triase_igd", "no_rawat=?", 
                            "no_rawat=?,tgl_kunjungan=?,cara_masuk=?,alat_transportasi=?,alasan_kedatangan=?,keterangan_kedatangan=?,"
                            + "kode_kasus=?,tekanan_darah=?,nadi=?,pernapasan=?,suhu=?,saturasi_o2=?,nyeri=?,keluhan_utama=?,"
                            + "kebutuhan_khusus=?,catatan=?,ESI1=?,ESI2=?,ESI3=?,ESI4=?,ESI5=?,cukupbulan=?,cairanamnion=?,"
                            + "pernafasan=?,tonus=?,isolasi1=?,psikologi=?,nyeritext=?,lokasi=?,durasi=?,frekuensi=?,gambnyeri=?,nip=?", 34, new String[]{
                                TNoRw.getText(), Valid.SetTgl(TanggalKunjungan.getSelectedItem() + "") + " " + TanggalKunjungan.getSelectedItem().toString().substring(11, 19),
                                CaraMasuk.getSelectedItem().toString(), Transportasi.getSelectedItem().toString(), AlasanKedatangan.getSelectedItem().toString(),
                                KeteranganKedatangan.getText(), KdKasus.getText(), PrimerTensi.getText(), PrimerNadi.getText(),
                                PrimerRespirasi.getText(), PrimerSuhu.getText(),
                                PrimerSaturasi.getText(), PrimerNyeri.getText(),
                                PrimerKeluhanUtama.getText(), PrimerKubutuhanKusus.getSelectedItem().toString(), PrimerCatatan.getText(), 
                                esi1, esi2, esi3, esi4, esi5, param1, param2, param3, param4, getIsolasi, getPsikologi, 
                                comboBox1.getSelectedItem().toString(), lokasinyeri.getText(), durasinyeri.getText(), frekuensinyeri.getText(), gambarannyeri.getText(), PrimerKodePetugas.getText(),
                                tbTriase.getValueAt(tbTriase.getSelectedRow(), 0).toString()
                            }) == true) {
                        System.out.println("Berhasil");
                        
                        Sequel.mengedittf("data_triase_igdprimer","no_rawat=?",
                            "no_rawat=?,keluhan_utama=?,kebutuhan_khusus=?,catatan=?,plan=?,tanggaltriase=?,nik=?", 8, new String[]{
                            TNoRw.getText(),
                            PrimerKeluhanUtama.getText(),
                            PrimerKubutuhanKusus.getSelectedItem().toString(),
                            PrimerCatatan.getText(),
                            keputusan,
                            Valid.SetTgl(PrimerTanggalTriase.getSelectedItem()+"")+" "+PrimerTanggalTriase.getSelectedItem().toString().substring(11,19), 
                            PrimerKodePetugas.getText(),
                            tbTriase.getValueAt(tbTriase.getSelectedRow(), 0).toString() // Parameter untuk Where no_rawat=?
                        });

                        emptTeks();
                        tampil();

                    }
                    
                }

            }

//            String kdDokter = PrimerKodePetugas.equals("") ? SekunderKodePetugas.getText() : PrimerKodePetugas.getText();
//
//            if (akses.getkode().equals("Admin Utama")) {
//                ganti();
//            } else {
//                if (kdDokter.equals(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(), 5).toString())) {
//                    ganti();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Hanya bisa diganti oleh dokter yang bersangkutan..!!");
//                }
//            }
            // }
        }
}//GEN-LAST:event_BtnEditActionPerformed

    private void ganti() {
        String kdDokter =  PrimerKodePetugas.getText();
        if(Sequel.mengedittf("penilaian_medis_igd","no_rawat=?","no_rawat=?,tanggal=?,kd_dokter=?,anamnesis=?,hubungan=?,keluhan_utama=?,rps=?,rpk=?,rpd=?,rpo=?,alergi=?,keadaan=?,gcs=?,kesadaran=?,td=?,nadi=?,rr=?,suhu=?,"+
                "spo=?,bb=?,tb=?,kepala=?,mata=?,gigi=?,leher=?,thoraks=?,abdomen=?,genital=?,ekstremitas=?,ket_fisik=?,ket_lokalis=?,ekg=?,rad=?,lab=?,diagnosis=?,tata=?",37,new String[]{
                TNoRw.getText(),Valid.SetTgl(TanggalKunjungan.getSelectedItem()+"")+" "+TanggalKunjungan.getSelectedItem().toString().substring(11,19),kdDokter,Anamnesis.getSelectedItem().toString(),Hubungan.getText(),
                    KeluhanUtama.getText(),RPS.getText(),RPD.getText(),RPK.getText(),RPO.getText(),Alergi.getText(),Keadaan.getSelectedItem().toString(),GCS.getText(),Kesadaran.getSelectedItem().toString(),TD.getText(),
                    Nadi.getText(),RR.getText(),Suhu.getText(),SPO.getText(),BB.getText(),TB.getText(),Kepala.getSelectedItem().toString(),Mata.getSelectedItem().toString(),Gigi.getSelectedItem().toString(),Leher.getSelectedItem().toString(),
                    Thoraks.getSelectedItem().toString(),Abdomen.getSelectedItem().toString(),Genital.getSelectedItem().toString(),Ekstremitas.getSelectedItem().toString(),KetFisik.getText(),KetLokalis.getText(),
                    EKG.getText(),Radiologi.getText(),Laborat.getText(),Diagnosis.getText(),Tatalaksana.getText(),tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),0).toString()
            })==true){
               tampilawalmedis();
               emptTeks();
               TabPilihan.setSelectedIndex(2);
        }
    }
    
    private void BtnEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnEditKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnEditActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnHapus, BtnPrint);
        }
}//GEN-LAST:event_BtnEditKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnKeluarActionPerformed(null);
        }else{Valid.pindah(evt,BtnEdit,TCari);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            TCari.requestFocus();
        }else if(tabMode.getRowCount()!=0){ 
            keputusan = (String)JOptionPane.showInputDialog(null,"Silahkan pilih laporan..!","Laporan Triase IGD",JOptionPane.QUESTION_MESSAGE,null,new Object[]{"Laporan 1","Laporan 2"},"Laporan 1");
            switch (keputusan) {
                case "Laporan 1":
                    Map<String, Object> param = new HashMap<>(); 
                    param.put("namars",akses.getnamars());
                    param.put("alamatrs",akses.getalamatrs());
                    param.put("kotars",akses.getkabupatenrs());
                    param.put("propinsirs",akses.getpropinsirs());
                    param.put("kontakrs",akses.getkontakrs());
                    param.put("emailrs",akses.getemailrs());   
                    param.put("logo",Sequel.cariGambar("select logo from setting")); 
                    Valid.MyReportqry("rptDataTriaseIGD.jasper","report","::[ Data Triase IGD ]::",
                        "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,data_triase_igd.tgl_kunjungan,"+
                        "data_triase_igd.cara_masuk,data_triase_igd.alat_transportasi,data_triase_igd.alasan_kedatangan,"+
                        "data_triase_igd.keterangan_kedatangan,data_triase_igd.kode_kasus,master_triase_macam_kasus.macam_kasus "+
                        "from reg_periksa inner join pasien inner join data_triase_igd inner join master_triase_macam_kasus "+
                        "on reg_periksa.no_rkm_medis=pasien.no_rkm_medis and reg_periksa.no_rawat=data_triase_igd.no_rawat "+
                        "and data_triase_igd.kode_kasus=master_triase_macam_kasus.kode_kasus "+
                        "where data_triase_igd.tgl_kunjungan between '"+Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00' and '"+Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59' and reg_periksa.no_rawat like '%"+TCari.getText().trim()+"%' or "+
                        "data_triase_igd.tgl_kunjungan between '"+Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00' and '"+Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59' and pasien.no_rkm_medis like '%"+TCari.getText().trim()+"%' or "+
                        "data_triase_igd.tgl_kunjungan between '"+Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00' and '"+Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59' and pasien.nm_pasien like '%"+TCari.getText().trim()+"%' or "+
                        "data_triase_igd.tgl_kunjungan between '"+Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00' and '"+Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59' and data_triase_igd.cara_masuk like '%"+TCari.getText().trim()+"%' or "+
                        "data_triase_igd.tgl_kunjungan between '"+Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00' and '"+Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59' and data_triase_igd.alat_transportasi like '%"+TCari.getText().trim()+"%' or "+
                        "data_triase_igd.tgl_kunjungan between '"+Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00' and '"+Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59' and data_triase_igd.alasan_kedatangan like '%"+TCari.getText().trim()+"%' or "+
                        "data_triase_igd.tgl_kunjungan between '"+Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00' and '"+Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59' and data_triase_igd.keterangan_kedatangan like '%"+TCari.getText().trim()+"%' or "+
                        "data_triase_igd.tgl_kunjungan between '"+Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00' and '"+Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59' and master_triase_macam_kasus.macam_kasus like '%"+TCari.getText().trim()+"%' order by data_triase_igd.tgl_kunjungan",param);
                    break;
                case "Laporan 2":
                    this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    try {
                        htmlContent = new StringBuilder();
                        htmlContent.append(                             
                            "<tr class='isi'>"+
                                "<td valign='middle' bgcolor='#FFFAF8' align='center' width='12%'><b>Pasien</b></td>"+
                                "<td valign='middle' bgcolor='#FFFAF8' align='center' width='12%'><b>Kunjungan</b></td>"+
                                "<td valign='middle' bgcolor='#FFFAF8' align='center' width='18%'><b>Kedatangan</b></td>"+
                                "<td valign='middle' bgcolor='#FFFAF8' align='center' width='13%'><b>Keluhan/Anamnesis Singkat</b></td>"+
                                "<td valign='middle' bgcolor='#FFFAF8' align='center' width='10%'><b>Tanda Vital</b></td>"+
                                "<td valign='middle' bgcolor='#FFFAF8' align='center' width='21%'><b>Pemeriksaan</b></td>"+
                                "<td valign='middle' bgcolor='#FFFAF8' align='center' width='14%'><b>Keputusan</b></td>"+
                            "</tr>"
                        );
                        
                        for(i=0;i<tabMode.getRowCount();i++){  
                            htmlContent.append(                             
                                "<tr class='isi'>"+
                                    "<td valign='top' cellpadding='0' cellspacing='0'>"+
                                        "<table width='100%' border='0' cellpadding='0' cellspacing='0'align='center'>"+
                                            "<tr class='isi2'>"+
                                                "<td width='34%' valign='top'>No.Rawat</td><td valign='top'>:&nbsp;</td><td width='65%' valign='top'>"+tbTriase.getValueAt(i,0).toString()+"</td>"+
                                            "</tr>"+
                                            "<tr class='isi2'>"+
                                                "<td width='34%' valign='top'>No.R.M.</td><td valign='top'>:&nbsp;</td><td width='65%' valign='top'>"+tbTriase.getValueAt(i,1).toString()+"</td>"+
                                            "</tr>"+
                                            "<tr class='isi2'>"+
                                                "<td width='34%' valign='top'>Nama Pasien</td><td valign='top'>:&nbsp;</td><td width='65%' valign='top'>"+tbTriase.getValueAt(i,2).toString()+"</td>"+
                                            "</tr>"+
                                        "</table>"+
                                    "</td>"+
                                    "<td valign='top' cellpadding='0' cellspacing='0'>"+
                                        "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>"+
                                            "<tr class='isi2'>"+
                                                "<td width='34%' valign='top'>Tgl.Kunjungan</td><td valign='top'>:&nbsp;</td><td width='65%' valign='top'>"+tbTriase.getValueAt(i,3).toString()+"</td>"+
                                            "</tr>"+
                                            "<tr class='isi2'>"+
                                                "<td width='34%' valign='top'>Cara Masuk</td><td valign='top'>:</td><td width='65%' valign='top'>"+tbTriase.getValueAt(i,4).toString()+"</td>"+
                                            "</tr>"+
                                            "<tr class='isi2'>"+
                                                "<td width='34%' valign='top'>Transportasi</td><td valign='top'>:&nbsp;</td><td width='65%' valign='top'>"+tbTriase.getValueAt(i,5).toString()+"</td>"+
                                            "</tr>"+
                                        "</table>"+
                                    "</td>"+
                                    "<td valign='top' cellpadding='0' cellspacing='0'>"+
                                        "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>"+
                                            "<tr class='isi2'>"+
                                                "<td width='31%' valign='top'>Alasan Kedatangan</td><td valign='top'>:&nbsp;</td><td width='68%' valign='top'>"+tbTriase.getValueAt(i,6).toString()+"</td>"+
                                            "</tr>"+
                                            "<tr class='isi2'>"+
                                                "<td width='31%' valign='top'>Keterangan</td><td valign='top'>:&nbsp;</td><td width='68%' valign='top'>"+tbTriase.getValueAt(i,7).toString()+"</td>"+
                                            "</tr>"+
                                            "<tr class='isi2'>"+
                                                "<td width='31%' valign='top'>Macam Kasus</td><td valign='top'>:&nbsp;</td><td width='68%' valign='top'>"+tbTriase.getValueAt(i,9).toString()+"</td>"+
                                            "</tr>"+
                                        "</table>"+
                                    "</td>"
                            );
                            
                            ps=koneksi.prepareStatement(
                                "select data_triase_igdprimer.keluhan_utama,data_triase_igdprimer.kebutuhan_khusus,data_triase_igdprimer.catatan,"+
                                "data_triase_igdprimer.plan,data_triase_igdprimer.tanggaltriase,data_triase_igdprimer.nik,data_triase_igd.tekanan_darah,"+
                                "data_triase_igd.nadi,data_triase_igd.pernapasan,data_triase_igd.suhu,data_triase_igd.saturasi_o2,data_triase_igd.nyeri,"+
                                "data_triase_igd.no_rawat from data_triase_igdprimer inner join data_triase_igd on data_triase_igd.no_rawat="+
                                "data_triase_igdprimer.no_rawat where data_triase_igd.no_rawat=?");
                            try {
                                ps.setString(1,tbTriase.getValueAt(i,0).toString());
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    htmlContent.append(
                                        "<td valign='top'> Keluhan Utama : "+rs.getString("keluhan_utama")+"<br>Kebutuhan Khusus : "+rs.getString("kebutuhan_khusus")+"</td>"+
                                        "<td valign='top'> Suhu (C) : "+rs.getString("suhu")+", Respirasi(/menit) : "+rs.getString("pernapasan")+", Tensi : "+rs.getString("tekanan_darah")+", Nadi(/menit) : "+rs.getString("nadi")+", Saturasi O²(%) : "+rs.getString("saturasi_o2")+", Nyeri : "+rs.getString("nyeri")+"</td>"
                                    );
                                    ps2=koneksi.prepareStatement(
                                        "select master_triase_pemeriksaan.kode_pemeriksaan,master_triase_pemeriksaan.nama_pemeriksaan "+
                                        "from master_triase_pemeriksaan inner join master_triase_skala1 inner join data_triase_igddetail_skala1 "+
                                        "on master_triase_pemeriksaan.kode_pemeriksaan=master_triase_skala1.kode_pemeriksaan and "+
                                        "master_triase_skala1.kode_skala1=data_triase_igddetail_skala1.kode_skala1 where data_triase_igddetail_skala1.no_rawat=? "+
                                        "group by master_triase_pemeriksaan.kode_pemeriksaan order by master_triase_pemeriksaan.kode_pemeriksaan");
                                    try {
                                        ps2.setString(1,rs.getString("no_rawat"));
                                        rs2=ps2.executeQuery();
                                        if(rs2.next()){
                                            htmlContent.append(
                                                "<td valign='top'>"+
                                                    "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>"
                                            );
                                            rs2.beforeFirst();
                                            while(rs2.next()){
                                                htmlContent.append(
                                                    "<tr class='isi5'>"+
                                                        "<td width='40%' valign='top'>"+rs2.getString("nama_pemeriksaan")+"</td>"+
                                                        "<td valign='top'>:&nbsp;</td>"+
                                                        "<td width='59%' valign='top'>"+
                                                            "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>"
                                                    );
                                                ps3=koneksi.prepareStatement(
                                                    "select master_triase_skala1.pengkajian_skala1 from master_triase_skala1 inner join data_triase_igddetail_skala1 "+
                                                    "on master_triase_skala1.kode_skala1=data_triase_igddetail_skala1.kode_skala1 where "+
                                                    "master_triase_skala1.kode_pemeriksaan=? and data_triase_igddetail_skala1.no_rawat=? "+
                                                    "order by data_triase_igddetail_skala1.kode_skala1");
                                                try {
                                                    ps3.setString(1,rs2.getString("kode_pemeriksaan"));
                                                    ps3.setString(2,rs.getString("no_rawat"));
                                                    rs3=ps3.executeQuery();
                                                    while(rs3.next()){
                                                        htmlContent.append(                             
                                                            "<tr class='isi5'>"+
                                                                "<td border='0' valign='middle' width='100%'>"+rs3.getString("pengkajian_skala1")+"</td>"+
                                                            "</tr>"
                                                        );
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println("Notif : "+e);
                                                } finally{
                                                    if(rs3!=null){
                                                        rs3.close();
                                                    }
                                                    if(ps3!=null){
                                                        ps3.close();
                                                    }
                                                }
                                                htmlContent.append(
                                                            "</table>"+
                                                        "</td>"+
                                                    "</tr>"
                                                );
                                            }
                                            htmlContent.append(
                                                    "</table>"+
                                                "</td>"
                                            );
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Notif : "+e);
                                    } finally{
                                        if(rs2!=null){
                                            rs2.close();
                                        }
                                        if(ps2!=null){
                                            ps2.close();
                                        }
                                    }
                                    
                                    ps2=koneksi.prepareStatement(
                                        "select master_triase_pemeriksaan.kode_pemeriksaan,master_triase_pemeriksaan.nama_pemeriksaan "+
                                        "from master_triase_pemeriksaan inner join master_triase_skala2 inner join data_triase_igddetail_skala2 "+
                                        "on master_triase_pemeriksaan.kode_pemeriksaan=master_triase_skala2.kode_pemeriksaan and "+
                                        "master_triase_skala2.kode_skala2=data_triase_igddetail_skala2.kode_skala2 where data_triase_igddetail_skala2.no_rawat=? "+
                                        "group by master_triase_pemeriksaan.kode_pemeriksaan order by master_triase_pemeriksaan.kode_pemeriksaan");
                                    try {
                                        ps2.setString(1,rs.getString("no_rawat"));
                                        rs2=ps2.executeQuery();
                                        if(rs2.next()){
                                            htmlContent.append(
                                                "<td valign='top'>"+
                                                    "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>"
                                            );
                                            rs2.beforeFirst();
                                            while(rs2.next()){
                                                htmlContent.append(
                                                    "<tr class='isi6'>"+
                                                        "<td width='40%' valign='top'>"+rs2.getString("nama_pemeriksaan")+"</td>"+
                                                        "<td valign='top'>:&nbsp;</td>"+
                                                        "<td width='59%' valign='top'>"+
                                                            "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>"
                                                    );
                                                ps3=koneksi.prepareStatement(
                                                    "select master_triase_skala2.pengkajian_skala2 from master_triase_skala2 inner join data_triase_igddetail_skala2 "+
                                                    "on master_triase_skala2.kode_skala2=data_triase_igddetail_skala2.kode_skala2 where "+
                                                    "master_triase_skala2.kode_pemeriksaan=? and data_triase_igddetail_skala2.no_rawat=? "+
                                                    "order by data_triase_igddetail_skala2.kode_skala2");
                                                try {
                                                    ps3.setString(1,rs2.getString("kode_pemeriksaan"));
                                                    ps3.setString(2,rs.getString("no_rawat"));
                                                    rs3=ps3.executeQuery();
                                                    while(rs3.next()){
                                                        htmlContent.append(                             
                                                            "<tr class='isi6'>"+
                                                                "<td border='0' valign='middle' width='100%'>"+rs3.getString("pengkajian_skala2")+"</td>"+
                                                            "</tr>"
                                                        );
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println("Notif : "+e);
                                                } finally{
                                                    if(rs3!=null){
                                                        rs3.close();
                                                    }
                                                    if(ps3!=null){
                                                        ps3.close();
                                                    }
                                                }
                                                htmlContent.append(
                                                            "</table>"+
                                                        "</td>"+
                                                    "</tr>"
                                                );
                                            }
                                            htmlContent.append(
                                                    "</table>"+
                                                "</td>"
                                            );
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Notif : "+e);
                                    } finally{
                                        if(rs2!=null){
                                            rs2.close();
                                        }
                                        if(ps2!=null){
                                            ps2.close();
                                        }
                                    }
                                    htmlContent.append(
                                        "<td valign='top' cellpadding='0' cellspacing='0'>"+
                                            "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>"+
                                                "<tr class='isi2'>"+
                                                    "<td width='34%' valign='top'>Keputusan</td><td valign='top'>:&nbsp;</td><td width='65%' valign='top'>"+rs.getString("plan")+"</td>"+
                                                "</tr>"+
                                                "<tr class='isi2'>"+
                                                    "<td width='34%' valign='top'>Tanggal & Jam</td><td valign='top'>:&nbsp;</td><td width='65%' valign='top'>"+rs.getString("tanggaltriase")+"</td>"+
                                                "</tr>"+
                                                "<tr class='isi2'>"+
                                                    "<td width='34%' valign='top'>Catatan</td><td valign='top'>:&nbsp;</td><td width='65%' valign='top'>"+rs.getString("catatan")+"</td>"+
                                                "</tr>"+
                                                "<tr class='isi2'>"+
                                                    "<td width='34%' valign='top'>Dokter/Petugas</td><td valign='top'>:&nbsp;</td><td width='65%' valign='top'>"+rs.getString("nik")+" "+Sequel.cariIsi("select nama from pegawai where nik=?",rs.getString("nik"))+"</td>"+
                                                "</tr>"+
                                            "</table>"+
                                        "</td>"
                                    );
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            
                            ps=koneksi.prepareStatement(
                                "select data_triase_igdsekunder.anamnesa_singkat,data_triase_igdsekunder.catatan,"+
                                "data_triase_igdsekunder.plan,data_triase_igdsekunder.tanggaltriase,data_triase_igdsekunder.nik,data_triase_igd.tekanan_darah,"+
                                "data_triase_igd.nadi,data_triase_igd.pernapasan,data_triase_igd.suhu,data_triase_igd.saturasi_o2,data_triase_igd.nyeri,"+
                                "data_triase_igd.no_rawat from data_triase_igdsekunder inner join data_triase_igd on data_triase_igd.no_rawat="+
                                "data_triase_igdsekunder.no_rawat where data_triase_igd.no_rawat=?");
                            try {
                                ps.setString(1,tbTriase.getValueAt(i,0).toString());
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    htmlContent.append(
                                        "<td valign='top'> Anamnesa Singkat : "+rs.getString("anamnesa_singkat")+"</td>"+
                                        "<td valign='top'> Suhu (C) : "+rs.getString("suhu")+", Respirasi(/menit) : "+rs.getString("pernapasan")+", Tensi : "+rs.getString("tekanan_darah")+", Nadi(/menit) : "+rs.getString("nadi")+", Saturasi O²(%) : "+rs.getString("saturasi_o2")+", Nyeri : "+rs.getString("nyeri")+"</td>"
                                    );
                                    ps2=koneksi.prepareStatement(
                                        "select master_triase_pemeriksaan.kode_pemeriksaan,master_triase_pemeriksaan.nama_pemeriksaan "+
                                        "from master_triase_pemeriksaan inner join master_triase_skala3 inner join data_triase_igddetail_skala3 "+
                                        "on master_triase_pemeriksaan.kode_pemeriksaan=master_triase_skala3.kode_pemeriksaan and "+
                                        "master_triase_skala3.kode_skala3=data_triase_igddetail_skala3.kode_skala3 where data_triase_igddetail_skala3.no_rawat=? "+
                                        "group by master_triase_pemeriksaan.kode_pemeriksaan order by master_triase_pemeriksaan.kode_pemeriksaan");
                                    try {
                                        ps2.setString(1,rs.getString("no_rawat"));
                                        rs2=ps2.executeQuery();
                                        if(rs2.next()){
                                            htmlContent.append(
                                                "<td valign='top'>"+
                                                    "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>"
                                            );
                                            rs2.beforeFirst();
                                            while(rs2.next()){
                                                htmlContent.append(
                                                    "<tr class='isi7'>"+
                                                        "<td width='40%' valign='top'>"+rs2.getString("nama_pemeriksaan")+"</td>"+
                                                        "<td valign='top'>:&nbsp;</td>"+
                                                        "<td width='59%' valign='top'>"+
                                                            "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>"
                                                    );
                                                ps3=koneksi.prepareStatement(
                                                    "select master_triase_skala3.pengkajian_skala3 from master_triase_skala3 inner join data_triase_igddetail_skala3 "+
                                                    "on master_triase_skala3.kode_skala3=data_triase_igddetail_skala3.kode_skala3 where "+
                                                    "master_triase_skala3.kode_pemeriksaan=? and data_triase_igddetail_skala3.no_rawat=? "+
                                                    "order by data_triase_igddetail_skala3.kode_skala3");
                                                try {
                                                    ps3.setString(1,rs2.getString("kode_pemeriksaan"));
                                                    ps3.setString(2,rs.getString("no_rawat"));
                                                    rs3=ps3.executeQuery();
                                                    while(rs3.next()){
                                                        htmlContent.append(                             
                                                            "<tr class='isi7'>"+
                                                                "<td border='0' valign='middle' width='100%'>"+rs3.getString("pengkajian_skala3")+"</td>"+
                                                            "</tr>"
                                                        );
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println("Notif : "+e);
                                                } finally{
                                                    if(rs3!=null){
                                                        rs3.close();
                                                    }
                                                    if(ps3!=null){
                                                        ps3.close();
                                                    }
                                                }
                                                htmlContent.append(
                                                            "</table>"+
                                                        "</td>"+
                                                    "</tr>"
                                                );
                                            }
                                            htmlContent.append(
                                                    "</table>"+
                                                "</td>"
                                            );
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Notif : "+e);
                                    } finally{
                                        if(rs2!=null){
                                            rs2.close();
                                        }
                                        if(ps2!=null){
                                            ps2.close();
                                        }
                                    }
                                    
                                    ps2=koneksi.prepareStatement(
                                        "select master_triase_pemeriksaan.kode_pemeriksaan,master_triase_pemeriksaan.nama_pemeriksaan "+
                                        "from master_triase_pemeriksaan inner join master_triase_skala4 inner join data_triase_igddetail_skala4 "+
                                        "on master_triase_pemeriksaan.kode_pemeriksaan=master_triase_skala4.kode_pemeriksaan and "+
                                        "master_triase_skala4.kode_skala4=data_triase_igddetail_skala4.kode_skala4 where data_triase_igddetail_skala4.no_rawat=? "+
                                        "group by master_triase_pemeriksaan.kode_pemeriksaan order by master_triase_pemeriksaan.kode_pemeriksaan");
                                    try {
                                        ps2.setString(1,rs.getString("no_rawat"));
                                        rs2=ps2.executeQuery();
                                        if(rs2.next()){
                                            htmlContent.append(
                                                "<td valign='top'>"+
                                                    "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>"
                                            );
                                            rs2.beforeFirst();
                                            while(rs2.next()){
                                                htmlContent.append(
                                                    "<tr class='isi8'>"+
                                                        "<td width='40%' valign='top'>"+rs2.getString("nama_pemeriksaan")+"</td>"+
                                                        "<td valign='top'>:&nbsp;</td>"+
                                                        "<td width='59%' valign='top'>"+
                                                            "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>"
                                                    );
                                                ps3=koneksi.prepareStatement(
                                                    "select master_triase_skala4.pengkajian_skala4 from master_triase_skala4 inner join data_triase_igddetail_skala4 "+
                                                    "on master_triase_skala4.kode_skala4=data_triase_igddetail_skala4.kode_skala4 where "+
                                                    "master_triase_skala4.kode_pemeriksaan=? and data_triase_igddetail_skala4.no_rawat=? "+
                                                    "order by data_triase_igddetail_skala4.kode_skala4");
                                                try {
                                                    ps3.setString(1,rs2.getString("kode_pemeriksaan"));
                                                    ps3.setString(2,rs.getString("no_rawat"));
                                                    rs3=ps3.executeQuery();
                                                    while(rs3.next()){
                                                        htmlContent.append(                             
                                                            "<tr class='isi8'>"+
                                                                "<td border='0' valign='middle' width='100%'>"+rs3.getString("pengkajian_skala4")+"</td>"+
                                                            "</tr>"
                                                        );
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println("Notif : "+e);
                                                } finally{
                                                    if(rs3!=null){
                                                        rs3.close();
                                                    }
                                                    if(ps3!=null){
                                                        ps3.close();
                                                    }
                                                }
                                                htmlContent.append(
                                                            "</table>"+
                                                        "</td>"+
                                                    "</tr>"
                                                );
                                            }
                                            htmlContent.append(
                                                    "</table>"+
                                                "</td>"
                                            );
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Notif : "+e);
                                    } finally{
                                        if(rs2!=null){
                                            rs2.close();
                                        }
                                        if(ps2!=null){
                                            ps2.close();
                                        }
                                    }
                                    
                                    ps2=koneksi.prepareStatement(
                                        "select master_triase_pemeriksaan.kode_pemeriksaan,master_triase_pemeriksaan.nama_pemeriksaan "+
                                        "from master_triase_pemeriksaan inner join master_triase_skala5 inner join data_triase_igddetail_skala5 "+
                                        "on master_triase_pemeriksaan.kode_pemeriksaan=master_triase_skala5.kode_pemeriksaan and "+
                                        "master_triase_skala5.kode_skala5=data_triase_igddetail_skala5.kode_skala5 where data_triase_igddetail_skala5.no_rawat=? "+
                                        "group by master_triase_pemeriksaan.kode_pemeriksaan order by master_triase_pemeriksaan.kode_pemeriksaan");
                                    try {
                                        ps2.setString(1,rs.getString("no_rawat"));
                                        rs2=ps2.executeQuery();
                                        if(rs2.next()){
                                            htmlContent.append(
                                                "<td valign='top'>"+
                                                    "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>"
                                            );
                                            rs2.beforeFirst();
                                            while(rs2.next()){
                                                htmlContent.append(
                                                    "<tr class='isi9'>"+
                                                        "<td width='40%' valign='top'>"+rs2.getString("nama_pemeriksaan")+"</td>"+
                                                        "<td valign='top'>:&nbsp;</td>"+
                                                        "<td width='59%' valign='top'>"+
                                                            "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>"
                                                    );
                                                ps3=koneksi.prepareStatement(
                                                    "select master_triase_skala5.pengkajian_skala5 from master_triase_skala5 inner join data_triase_igddetail_skala5 "+
                                                    "on master_triase_skala5.kode_skala5=data_triase_igddetail_skala5.kode_skala5 where "+
                                                    "master_triase_skala5.kode_pemeriksaan=? and data_triase_igddetail_skala5.no_rawat=? "+
                                                    "order by data_triase_igddetail_skala5.kode_skala5");
                                                try {
                                                    ps3.setString(1,rs2.getString("kode_pemeriksaan"));
                                                    ps3.setString(2,rs.getString("no_rawat"));
                                                    rs3=ps3.executeQuery();
                                                    while(rs3.next()){
                                                        htmlContent.append(                             
                                                            "<tr class='isi9'>"+
                                                                "<td border='0' valign='middle' width='100%'>"+rs3.getString("pengkajian_skala5")+"</td>"+
                                                            "</tr>"
                                                        );
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println("Notif : "+e);
                                                } finally{
                                                    if(rs3!=null){
                                                        rs3.close();
                                                    }
                                                    if(ps3!=null){
                                                        ps3.close();
                                                    }
                                                }
                                                htmlContent.append(
                                                            "</table>"+
                                                        "</td>"+
                                                    "</tr>"
                                                );
                                            }
                                            htmlContent.append(
                                                    "</table>"+
                                                "</td>"
                                            );
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Notif : "+e);
                                    } finally{
                                        if(rs2!=null){
                                            rs2.close();
                                        }
                                        if(ps2!=null){
                                            ps2.close();
                                        }
                                    }
                                    htmlContent.append(
                                        "<td valign='top' cellpadding='0' cellspacing='0'>"+
                                            "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>"+
                                                "<tr class='isi2'>"+
                                                    "<td width='34%' valign='top'>Keputusan</td><td valign='top'>:&nbsp;</td><td width='65%' valign='top'>"+rs.getString("plan")+"</td>"+
                                                "</tr>"+
                                                "<tr class='isi2'>"+
                                                    "<td width='34%' valign='top'>Tanggal & Jam</td><td valign='top'>:&nbsp;</td><td width='65%' valign='top'>"+rs.getString("tanggaltriase")+"</td>"+
                                                "</tr>"+
                                                "<tr class='isi2'>"+
                                                    "<td width='34%' valign='top'>Catatan</td><td valign='top'>:&nbsp;</td><td width='65%' valign='top'>"+rs.getString("catatan")+"</td>"+
                                                "</tr>"+
                                                "<tr class='isi2'>"+
                                                    "<td width='34%' valign='top'>Dokter/Petugas</td><td valign='top'>:&nbsp;</td><td width='65%' valign='top'>"+rs.getString("nik")+" "+Sequel.cariIsi("select nama from pegawai where nik=?",rs.getString("nik"))+"</td>"+
                                                "</tr>"+
                                            "</table>"+
                                        "</td>"
                                    );
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            
                            htmlContent.append(
                                "</tr>"
                            );
                        }
                        
                        LoadHTML2.setText(
                            "<html>"+
                              "<table width='1400px' border='0' align='center' cellpadding='1px' cellspacing='0' class='tbl_form'>"+
                               htmlContent.toString()+
                              "</table>"+
                            "</html>"
                        );
                        
                        File g = new File("file2.css");            
                        BufferedWriter bg = new BufferedWriter(new FileWriter(g));
                        bg.write(
                            ".isi td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-bottom: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                            ".isi2 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#323232;}"+
                            ".isi3 td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                            ".isi4 td{font: 11px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                            ".isi5 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#AA0000;}"+
                            ".isi6 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#FF0000;}"+
                            ".isi7 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#C8C800;}"+
                            ".isi8 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#00AA00;}"+
                            ".isi9 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#969696;}"
                        );
                        bg.close();

                        File f = new File("DataTriaseIGD.html");            
                        BufferedWriter bw = new BufferedWriter(new FileWriter(f));            
                        bw.write(LoadHTML2.getText().replaceAll("<head>","<head>"+
                                    "<link href=\"file2.css\" rel=\"stylesheet\" type=\"text/css\" />"+
                                    "<table width='1400px' border='0' align='center' cellpadding='3px' cellspacing='0' class='tbl_form'>"+
                                        "<tr class='isi2'>"+
                                            "<td valign='top' align='center'>"+
                                                "<font size='4' face='Tahoma'>"+akses.getnamars()+"</font><br>"+
                                                akses.getalamatrs()+", "+akses.getkabupatenrs()+", "+akses.getpropinsirs()+"<br>"+
                                                akses.getkontakrs()+", E-mail : "+akses.getemailrs()+"<br><br>"+
                                                "<font size='2' face='Tahoma'>DATA TRIASE IGD<br><br></font>"+        
                                            "</td>"+
                                       "</tr>"+
                                    "</table>")
                        );
                        bw.close();                         
                        Desktop.getDesktop().browse(f.toURI());
                    } catch (Exception e) {
                        System.out.println("Notifikasi : "+e);
                    }
                    this.setCursor(Cursor.getDefaultCursor());
                    TNoRM1.setText("");
                    TPasien1.setText("");
                    LoadHTML.setText("");
                    ChkAccor.setSelected(false);
                    isMenu();
                    break;
            }
        }
        this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnEdit, BtnKeluar);
        }
}//GEN-LAST:event_BtnPrintKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        tampil();
}//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            TCari.setText("");
            tampil();
            tampilawalmedis();
        }else{
            Valid.pindah(evt, BtnCari, TPasien);
            Valid.pindah(evt, BtnCari2, TPasien);
        }
}//GEN-LAST:event_BtnAllKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampilPemeriksaan();
//        tampilPemeriksaan2();
        tampil();
        tampilawalmedis();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(this.getHeight()<620){   
            ScrollTriase.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            FormTriase.setPreferredSize(new Dimension(FormTriase.WIDTH,500));
            if(this.getWidth()<780){
                ScrollTriase.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);                                
                FormTriase.setPreferredSize(new Dimension(770,500));
            }else{
                ScrollTriase.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);                
            }
        }else{
            ScrollTriase.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);            
            if(this.getWidth()<780){
                ScrollTriase.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);                                
                FormTriase.setPreferredSize(new Dimension(770,FormTriase.HEIGHT));
            }else{
                ScrollTriase.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);                
            }
        }
    }//GEN-LAST:event_formWindowActivated

    private void TabPilihanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabPilihanMouseClicked
        if(TabPilihan.getSelectedIndex()==1){
            tampil();
        }
        if(TabPilihan.getSelectedIndex()==2){
            tampilawalmedis();
        }
    }//GEN-LAST:event_TabPilihanMouseClicked

    private void BtnPrint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrint1ActionPerformed
        if(TNoRM1.getText().trim().equals("")||TPasien1.getText().trim().equals("")){
            Valid.textKosong(TCari,"Pasien");
        }else{
            if(tbTriase.getSelectedRow()> -1){
                this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                i=0;
                if(LoadHTML.getText().contains("#")){
                    Map<String, Object> param = new HashMap<>();
                    param.put("namars",akses.getnamars());
                    param.put("alamatrs",akses.getalamatrs());
                    param.put("kotars",akses.getkabupatenrs());
                    param.put("propinsirs",akses.getpropinsirs());
                    param.put("kontakrs",akses.getkontakrs());
                    param.put("emailrs",akses.getemailrs());
                    param.put("logo",Sequel.cariGambar("select logo from setting"));
                    param.put("nyeri",Sequel.cariGambar("select nyeri from gambar")); 
                    try {
                        ps=koneksi.prepareStatement(
                            "select data_triase_igdprimer.keluhan_utama,data_triase_igdprimer.kebutuhan_khusus,data_triase_igdprimer.catatan,"+
                            "data_triase_igdprimer.plan,data_triase_igdprimer.tanggaltriase,data_triase_igdprimer.nik,data_triase_igd.tekanan_darah,"+
                            "data_triase_igd.nadi,data_triase_igd.pernapasan,data_triase_igd.suhu,data_triase_igd.saturasi_o2,data_triase_igd.nyeri,"+
                            "data_triase_igd.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.tgl_lahir,pegawai.nama,data_triase_igd.tgl_kunjungan, "+
                            "data_triase_igd.cara_masuk,master_triase_macam_kasus.macam_kasus from data_triase_igdprimer inner join data_triase_igd "+
                            "inner join pasien inner join pegawai inner join reg_periksa inner join master_triase_macam_kasus on "+
                            "data_triase_igd.no_rawat=data_triase_igdprimer.no_rawat and reg_periksa.no_rawat=data_triase_igd.no_rawat "+
                            "and reg_periksa.no_rkm_medis=pasien.no_rkm_medis and pegawai.nik=data_triase_igdprimer.nik "+
                            "and master_triase_macam_kasus.kode_kasus=data_triase_igd.kode_kasus where data_triase_igd.no_rawat=?");
//                        ps = koneksi.prepareStatement(
//                                "select data_triase_igd.keluhan_utama,data_triase_igd.kebutuhan_khusus,data_triase_igd.catatan,data_triase_igd.tgl_kunjungan,data_triase_igd.tekanan_darah,\n"
//                                + "data_triase_igd.nadi,data_triase_igd.pernapasan,data_triase_igd.suhu,data_triase_igd.saturasi_o2,data_triase_igd.nyeri,data_triase_igd.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,"
//                                + "pasien.tgl_lahir,data_triase_igd.tgl_kunjungan,data_triase_igd.cara_masuk,master_triase_macam_kasus.macam_kasus,pegawai.nama from data_triase_igd inner join pasien  "
//                                + "inner join reg_periksa inner join master_triase_macam_kasus inner join pegawai on reg_periksa.no_rawat=data_triase_igd.no_rawat and reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
//                                + "and master_triase_macam_kasus.kode_kasus=data_triase_igd.kode_kasus and pegawai.nik=data_triase_igd.nik where data_triase_igd.no_rawat=?");
                        try {
                            ps.setString(1, tbTriase.getValueAt(tbTriase.getSelectedRow(), 0).toString());
                            rs = ps.executeQuery();
                            if(rs.next()){
                                param.put("norawat",rs.getString("no_rawat"));
                                param.put("norm",rs.getString("no_rkm_medis"));
                                param.put("namapasien",rs.getString("nm_pasien"));
                                param.put("tanggallahir",rs.getDate("tgl_lahir"));
                                param.put("jk",rs.getString("jk").replaceAll("L","Laki-Laki").replaceAll("P","Perempuan"));
                                param.put("tanggalkunjungan",rs.getDate("tgl_kunjungan"));
                                param.put("jamkunjungan",rs.getString("tgl_kunjungan").toString().substring(11,19));
                                param.put("caradatang",rs.getString("cara_masuk"));
                                param.put("macamkasus",rs.getString("macam_kasus"));
                                param.put("keluhanutama",rs.getString("keluhan_utama"));
                                param.put("kebutuhankhusus",rs.getString("kebutuhan_khusus"));
                                param.put("plan",rs.getString("plan"));
                                param.put("tanggaltriase",rs.getDate("tgl_kunjungan"));
                                param.put("jamtriase",rs.getString("tgl_kunjungan").toString().substring(11,19));
                                param.put("pegawai",rs.getString("nama"));
                                param.put("catatan",rs.getString("catatan"));
                                param.put("tandavital","Suhu (C) : "+rs.getString("suhu")+", Nyeri : "+rs.getString("nyeri")+", Tensi : "+rs.getString("tekanan_darah")+", Nadi(/menit) : "+rs.getString("nadi")+", Saturasi O²(%) : "+rs.getString("saturasi_o2")+", Respirasi(/menit) : "+rs.getString("pernapasan"));
                                
                                
                                //finger=Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",rs.getString("nik"));
                                //param.put("finger","Dikeluarkan di "+akses.getnamars()+", Kabupaten/Kota "+akses.getkabupatenrs()+"\nDitandatangani secara elektronik oleh "+rs.getString("nama")+"\nID "+(finger.equals("")?rs.getString("nik"):finger)+"\n"+Valid.SetTgl3(rs.getString("tanggaltriase")));
                                ps2=koneksi.prepareStatement(
                                    "select master_triase_pemeriksaan.kode_pemeriksaan,master_triase_pemeriksaan.nama_pemeriksaan "+
                                    "from master_triase_pemeriksaan inner join master_triase_skala1 inner join data_triase_igddetail_skala1 "+
                                    "on master_triase_pemeriksaan.kode_pemeriksaan=master_triase_skala1.kode_pemeriksaan and "+
                                    "master_triase_skala1.kode_skala1=data_triase_igddetail_skala1.kode_skala1 where data_triase_igddetail_skala1.no_rawat=? "+
                                    "group by master_triase_pemeriksaan.kode_pemeriksaan order by master_triase_pemeriksaan.kode_pemeriksaan");
                                try {
                                    Sequel.queryu("delete from temporary where temp37='"+akses.getalamatip()+"'");
                                    ps2.setString(1,rs.getString("no_rawat"));
                                    rs2=ps2.executeQuery();
                                    while(rs2.next()){
                                        datatriase="";
                                        ps3=koneksi.prepareStatement(
                                            "select master_triase_skala1.pengkajian_skala1 from master_triase_skala1 inner join data_triase_igddetail_skala1 "+
                                            "on master_triase_skala1.kode_skala1=data_triase_igddetail_skala1.kode_skala1 where "+
                                            "master_triase_skala1.kode_pemeriksaan=? and data_triase_igddetail_skala1.no_rawat=? "+
                                            "order by data_triase_igddetail_skala1.kode_skala1");
                                        try {
                                            ps3.setString(1,rs2.getString("kode_pemeriksaan"));
                                            ps3.setString(2,rs.getString("no_rawat"));
                                            rs3=ps3.executeQuery();
                                            while(rs3.next()){
                                                datatriase=rs3.getString("pengkajian_skala1")+", "+datatriase;
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Notif : "+e);
                                        } finally{
                                            if(rs3!=null){
                                                rs3.close();
                                            }
                                            if(ps3!=null){
                                                ps3.close();
                                            }
                                        }

                                        if(datatriase.endsWith(", ")){
                                            datatriase = datatriase.substring(0,datatriase.length() - 2);
                                        }
                                        Sequel.menyimpan2("temporary","'"+i+"','"+rs2.getString("nama_pemeriksaan")+"','"+datatriase+"','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','"+akses.getalamatip()+"'","Transaksi");
                                        i++;
                                    }
                                } catch (Exception e) {
                                    System.out.println("Notif : "+e);
                                } finally{
                                    if(rs2!=null){
                                        rs2.close();
                                    }
                                    if(ps2!=null){
                                        ps2.close();
                                    }
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Notif : "+e);
                        } finally{
                            if(rs!=null){
                                rs.close();
                            }
                            if(ps!=null){
                                ps.close();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Notif : "+e);
                    }

                    pilihan = (String)JOptionPane.showInputDialog(null,"Silahkan pilih Lembar/PDF Triase Skala 1..!","Pilihan",JOptionPane.QUESTION_MESSAGE,null,new Object[]{"Lembar Triase Skala 1","PDF Triase Skala 1"},"Lambar Triase Skala 1");
                    if(pilihan != null){
                        switch (pilihan) {
                            case "Lembar Triase Skala 1":
                            Valid.MyReportqry("rptLembarTriase.jasper","report","::[ Triase Skala 1 ]::","select data_triase_igd.keluhan_utama,data_triase_igd.kebutuhan_khusus,data_triase_igd.catatan,data_triase_igd.tgl_kunjungan,data_triase_igd.tekanan_darah, data_triase_igd.nadi,data_triase_igd.pernapasan,data_triase_igd.suhu,data_triase_igd.saturasi_o2,data_triase_igd.nyeri,data_triase_igd.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,\n" +
"                                 pasien.tgl_lahir,data_triase_igd.tgl_kunjungan,data_triase_igd.cara_masuk,master_triase_macam_kasus.macam_kasus,data_triase_igd.ESI1,data_triase_igd.ESI2,data_triase_igd.ESI3,data_triase_igd.ESI4,data_triase_igd.ESI5,data_triase_igd.cukupbulan,data_triase_igd.cairanamnion,\n" +
"                                  data_triase_igd.pernafasan,data_triase_igd.tonus,data_triase_igd.isolasi1,data_triase_igd.psikologi,data_triase_igd.nyeritext,data_triase_igd.lokasi,data_triase_igd.durasi,data_triase_igd.frekuensi,data_triase_igd.gambnyeri from data_triase_igd inner join pasien \n" +
"                                 inner join reg_periksa inner join master_triase_macam_kasus on reg_periksa.no_rawat=data_triase_igd.no_rawat and reg_periksa.no_rkm_medis=pasien.no_rkm_medis \n" +
"                                 and master_triase_macam_kasus.kode_kasus=data_triase_igd.kode_kasus where data_triase_igd.no_rawat='"+tbTriase.getValueAt(tbTriase.getSelectedRow(), 0).toString()+"'",param);
                            break;
                            case "PDF Triase Skala 1":
                            Valid.MyReportqrypdf("rptLembarTriase.jasper","report","::[ Triase Skala 1 ]::","select * from temporary where temporary.temp37='"+akses.getalamatip()+"' order by temporary.no",param);
                            break;
                        }
                    }
                }
                
                this.setCursor(Cursor.getDefaultCursor());
            }else{
                JOptionPane.showMessageDialog(null,"Silahkan pilih terlebih dahulu data yang mau dicetak data personal triasenya..!!!");
            }
        }
    }//GEN-LAST:event_BtnPrint1ActionPerformed

    private void ChkAccorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkAccorActionPerformed
        if(tbTriase.getSelectedRow()!= -1){
            isMenu();
        }else{
            ChkAccor.setSelected(false);
            JOptionPane.showMessageDialog(null,"Maaf, silahkan pilih data yang mau ditampilkan triasenya...!!!!");
        }
    }//GEN-LAST:event_ChkAccorActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, TCari, BtnAll);
        }
    }//GEN-LAST:event_BtnCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil();
        tampilawalmedis();
    }//GEN-LAST:event_BtnCariActionPerformed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            BtnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }
    }//GEN-LAST:event_TCariKeyPressed

    private void tbTriaseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbTriaseKeyReleased
        if(tabMode.getRowCount()!=0){
            if((evt.getKeyCode()==KeyEvent.VK_ENTER)||(evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
                try {
                    getData();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
    }//GEN-LAST:event_tbTriaseKeyReleased

    private void tbTriaseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbTriaseKeyPressed
        if(tabMode.getRowCount()!=0){
            if(evt.getKeyCode()==KeyEvent.VK_SHIFT){
                TCari.setText("");
                TCari.requestFocus();
            }else if(evt.getKeyCode()==KeyEvent.VK_SPACE){
                if(tbTriase.getSelectedRow()!= -1){
                    
                    getData(); // 1. Tarik semua datanya terlebih dahulu
                    TabPilihan.setSelectedIndex(0); // 2. Pindah ke Tab Input Utama
                    TabTriase.setSelectedIndex(0);
                    
            }
        }
        }
    }//GEN-LAST:event_tbTriaseKeyPressed

    private void tbTriaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTriaseMouseClicked
        if(tabMode.getRowCount()!=0){
            try {
                ChkAccor.setSelected(true);
                isMenu();
                getData();
            } catch (java.lang.NullPointerException e) {
            }
        }
    }//GEN-LAST:event_tbTriaseMouseClicked

    private void AnamnesisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AnamnesisKeyPressed
        //        Valid.pindah(evt,TglAsuhan,Hubungan);
    }//GEN-LAST:event_AnamnesisKeyPressed

    private void HubunganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HubunganKeyPressed
        Valid.pindah(evt,Anamnesis,KeluhanUtama);
    }//GEN-LAST:event_HubunganKeyPressed

    private void KeteranganKedatanganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganKedatanganKeyPressed

    }//GEN-LAST:event_KeteranganKedatanganKeyPressed

    private void btnKasusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnKasusKeyPressed
        Valid.pindah(evt,AlasanKedatangan,CaraMasuk);
    }//GEN-LAST:event_btnKasusKeyPressed

    private void btnKasusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKasusActionPerformed
        kasus.isCek();
        kasus.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        kasus.setLocationRelativeTo(internalFrame1);
        kasus.setVisible(true);
    }//GEN-LAST:event_btnKasusActionPerformed

    private void NmKasusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NmKasusKeyPressed
        //Valid.pindah(evt,kdskala,BtnSimpan);
    }//GEN-LAST:event_NmKasusKeyPressed

    private void KdKasusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KdKasusKeyPressed
        //Valid.pindah(evt, TCari,kdskala);
    }//GEN-LAST:event_KdKasusKeyPressed

    private void AlasanKedatanganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AlasanKedatanganKeyPressed
        Valid.pindah(evt,CaraMasuk,btnKasus);
    }//GEN-LAST:event_AlasanKedatanganKeyPressed

    private void TransportasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TransportasiKeyPressed
        Valid.pindah(evt,TCari,TanggalKunjungan);
    }//GEN-LAST:event_TransportasiKeyPressed

    private void CaraMasukKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CaraMasukKeyPressed
        Valid.pindah(evt,TanggalKunjungan,AlasanKedatangan);
    }//GEN-LAST:event_CaraMasukKeyPressed

    private void TanggalKunjunganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TanggalKunjunganKeyPressed
        Valid.pindah(evt,Transportasi,CaraMasuk);
    }//GEN-LAST:event_TanggalKunjunganKeyPressed

    private void TNoRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNoRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNoRMActionPerformed

    private void tbAwalMedisIGDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAwalMedisIGDMouseClicked
        if(TabModeAwal.getRowCount()!=0){
            try {
                getData2();
            } catch (java.lang.NullPointerException e) {
            }
        }
    }//GEN-LAST:event_tbAwalMedisIGDMouseClicked

    private void tbAwalMedisIGDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbAwalMedisIGDKeyPressed
        if(tabMode.getRowCount()!=0){
            if((evt.getKeyCode()==KeyEvent.VK_ENTER)||(evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
                try {
                    getData();
                } catch (java.lang.NullPointerException e) {
                }
            }else if(evt.getKeyCode()==KeyEvent.VK_SPACE){
                try {
                    getData();
                    TabPilihan.setSelectedIndex(0);
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
    }//GEN-LAST:event_tbAwalMedisIGDKeyPressed

    private void TCari2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCari2KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            BtnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }
    }//GEN-LAST:event_TCari2KeyPressed

    private void BtnCari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCari2ActionPerformed
        tampil();
    }//GEN-LAST:event_BtnCari2ActionPerformed

    private void BtnCari2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCari2KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, TCari, BtnAll);
        }
    }//GEN-LAST:event_BtnCari2KeyPressed

    private void ScrollMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScrollMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ScrollMouseClicked

    private void TabTriaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabTriaseMouseClicked
        if(TabTriase.getSelectedIndex()==1){
            PrimerKeluhanUtama.setText(KeluhanUtama.getText());
            PrimerSuhu.setText(Suhu.getText());
            PrimerNyeri.setText(Skalanyeri.getText());
            PrimerTensi.setText(TD.getText());
            PrimerNadi.setText(Nadi.getText());
            PrimerSaturasi.setText(SPO.getText());
            PrimerRespirasi.setText(RR.getText());
//        }else if(TabTriase.getSelectedIndex()==2){
//            SekunderAnamnesa.setText(KeluhanUtama.getText());
//            SekunderSuhu.setText(Suhu.getText());
//            SekunderNyeri.setText(Skalanyeri.getText());
//            SekunderTensi.setText(TD.getText());
//            SekunderNadi.setText(Nadi.getText());
//            SekunderSaturasi.setText(SPO.getText());
//            SekunderRespirasi.setText(RR.getText());
//
//            TabSkala3dan4dan5MouseClicked(null);
        }
    }//GEN-LAST:event_TabTriaseMouseClicked

    private void cekBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekBox12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekBox12ActionPerformed

    private void cekBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekBox11ActionPerformed

    private void cekBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekBox10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekBox10ActionPerformed

    private void cekBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekBox9ActionPerformed
        // TODO add your handling code here:
        kriteriaisolasi();
    }//GEN-LAST:event_cekBox9ActionPerformed

    private void cekBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekBox8ActionPerformed
        // TODO add your handling code here:
        kriteriaisolasi();
    }//GEN-LAST:event_cekBox8ActionPerformed

    private void cekBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekBox7ActionPerformed
        // TODO add your handling code here:
        kriteriaisolasi();
    }//GEN-LAST:event_cekBox7ActionPerformed

    private void cekBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekBox6ActionPerformed

    private void cekBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekBox5ActionPerformed
        // TODO add your handling code here:
        kriteriaisolasi();
    }//GEN-LAST:event_cekBox5ActionPerformed

    private void cbPrioritas3tidakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPrioritas3tidakActionPerformed
        // TODO add your handling code here:
        hitungPrioritas2b();

    }//GEN-LAST:event_cbPrioritas3tidakActionPerformed

    private void PrimerNyeriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerNyeriKeyPressed
        Valid.pindah(evt,PrimerSuhu,PrimerTensi);
    }//GEN-LAST:event_PrimerNyeriKeyPressed

    private void cbPrioritas2cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPrioritas2cActionPerformed
        // TODO add your handling code here:
        hitungPrioritas2();
    }//GEN-LAST:event_cbPrioritas2cActionPerformed

    private void cbPrioritas2aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPrioritas2aActionPerformed
        // TODO add your handling code here:
        hitungPrioritas2();
    }//GEN-LAST:event_cbPrioritas2aActionPerformed

    private void cbPrioritas2bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPrioritas2bActionPerformed
        // TODO add your handling code here:
        hitungPrioritas2();
    }//GEN-LAST:event_cbPrioritas2bActionPerformed

    private void cbPrioritas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPrioritas1ActionPerformed
        // TODO add your handling code here:
        hitungPrioritas1();
    }//GEN-LAST:event_cbPrioritas1ActionPerformed

    private void cbPrioritas543ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPrioritas543ActionPerformed
        // TODO add your handling code here:
        switch (cbPrioritas543.getSelectedIndex()) {
            case 0:
            hitungPrioritas3();
            jScrollPane1.setVisible(false);
            cbPrioritas3.setVisible(false);
            cbPrioritas3tidak.setVisible(false);
            break;
            case 1:
            hitungPrioritas3();
            jScrollPane1.setVisible(false);
            cbPrioritas3.setVisible(false);
            cbPrioritas3tidak.setVisible(false);
            break;
            case 2:
            hitungPrioritas3();
            jScrollPane1.setVisible(false);
            cbPrioritas3.setVisible(false);
            cbPrioritas3tidak.setVisible(false);
            break;
            case 3:
            jScrollPane1.setVisible(true);
            cbPrioritas3.setVisible(true);
            cbPrioritas3tidak.setVisible(true);
            prioritas3.setVisible(false);
            break;
            default:
            prioritas3.setVisible(false);

        }
    }//GEN-LAST:event_cbPrioritas543ActionPerformed

    private void tbPemeriksaanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPemeriksaanKeyReleased

    }//GEN-LAST:event_tbPemeriksaanKeyReleased

    private void tbPemeriksaanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPemeriksaanKeyPressed
        if(tabModePemeriksaan.getRowCount()!=0){
            if(evt.getKeyCode()==KeyEvent.VK_SHIFT){
                TCariPemeriksaan.setText("");
                TCariPemeriksaan.requestFocus();
            }
        }
    }//GEN-LAST:event_tbPemeriksaanKeyPressed

    private void tbPemeriksaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPemeriksaanMouseClicked
//        if(tabModePemeriksaan.getRowCount()!=0){
//            try {
//                tampilskala1();
//                tampilskala2();
//            } catch (java.lang.NullPointerException e) {
//            }
//        }
    }//GEN-LAST:event_tbPemeriksaanMouseClicked

    private void BtnTambahPemeriksaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahPemeriksaanActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MasterTriasePemeriksaan form=new MasterTriasePemeriksaan(null,false);
        form.isCek();
        form.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        form.setLocationRelativeTo(internalFrame1);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnTambahPemeriksaanActionPerformed

    private void BtnCariPemeriksaanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariPemeriksaanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCariPemeriksaanKeyPressed

    private void BtnCariPemeriksaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariPemeriksaanActionPerformed
        tampilPemeriksaan();
    }//GEN-LAST:event_BtnCariPemeriksaanActionPerformed

    private void TCariPemeriksaanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariPemeriksaanKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            tampilPemeriksaan();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            PrimerCatatan.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            PrimerKubutuhanKusus.requestFocus();
        }
    }//GEN-LAST:event_TCariPemeriksaanKeyPressed

    private void PrimerCatatanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerCatatanKeyPressed
        Valid.pindah(evt,TCariPemeriksaan,PrimerTanggalTriase);
    }//GEN-LAST:event_PrimerCatatanKeyPressed

    private void PrimerTanggalTriaseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerTanggalTriaseKeyPressed
        Valid.pindah(evt,PrimerCatatan,btnPrimerPetugas);
    }//GEN-LAST:event_PrimerTanggalTriaseKeyPressed

    private void btnPrimerPetugasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPrimerPetugasKeyReleased
        Valid.pindah(evt,PrimerTanggalTriase,BtnSimpan);
    }//GEN-LAST:event_btnPrimerPetugasKeyReleased

    private void btnPrimerPetugasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPrimerPetugasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrimerPetugasKeyPressed

    private void btnPrimerPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimerPetugasActionPerformed
        index=1;
        pegawai.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        pegawai.setLocationRelativeTo(internalFrame1);
        pegawai.setAlwaysOnTop(false);
        pegawai.setVisible(true);
    }//GEN-LAST:event_btnPrimerPetugasActionPerformed

    private void PrimerNamaPetugasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerNamaPetugasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrimerNamaPetugasKeyPressed

    private void PrimerKodePetugasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerKodePetugasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrimerKodePetugasKeyPressed

    private void PrimerTensiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerTensiKeyPressed
        Valid.pindah(evt,PrimerNyeri,PrimerNadi);
    }//GEN-LAST:event_PrimerTensiKeyPressed

    private void PrimerRespirasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerRespirasiKeyPressed
        Valid.pindah(evt,PrimerSaturasi,PrimerKubutuhanKusus);
    }//GEN-LAST:event_PrimerRespirasiKeyPressed

    private void PrimerNadiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerNadiKeyPressed
        Valid.pindah(evt,PrimerTensi,PrimerSaturasi);
    }//GEN-LAST:event_PrimerNadiKeyPressed

    private void PrimerNadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrimerNadiActionPerformed

    }//GEN-LAST:event_PrimerNadiActionPerformed

    private void PrimerSaturasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerSaturasiKeyPressed
        Valid.pindah(evt,PrimerNadi,PrimerRespirasi);
    }//GEN-LAST:event_PrimerSaturasiKeyPressed

    private void PrimerSuhuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerSuhuKeyPressed
        Valid.pindah(evt,PrimerKeluhanUtama,PrimerNyeri);
    }//GEN-LAST:event_PrimerSuhuKeyPressed

    private void PrimerKubutuhanKususKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerKubutuhanKususKeyPressed
        Valid.pindah(evt,PrimerRespirasi,TCariPemeriksaan);
    }//GEN-LAST:event_PrimerKubutuhanKususKeyPressed

    private void PrimerKeluhanUtamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerKeluhanUtamaKeyPressed
        Valid.pindah2(evt,KeteranganKedatangan,PrimerSuhu);
    }//GEN-LAST:event_PrimerKeluhanUtamaKeyPressed

    private void SkalanyeriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalanyeriKeyPressed
        //        Valid.pindah(evt,PrimerSuhu,PrimerTensi);
    }//GEN-LAST:event_SkalanyeriKeyPressed

    private void TatalaksanaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TatalaksanaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TatalaksanaKeyPressed

    private void LaboratKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LaboratKeyPressed
        Valid.pindah2(evt,Radiologi,Diagnosis);
    }//GEN-LAST:event_LaboratKeyPressed

    private void RadiologiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RadiologiKeyPressed
        Valid.pindah2(evt,EKG,Laborat);
    }//GEN-LAST:event_RadiologiKeyPressed

    private void MataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MataKeyPressed
        Valid.pindah(evt,Kepala,Gigi);
    }//GEN-LAST:event_MataKeyPressed

    private void DiagnosisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DiagnosisKeyPressed
        Valid.pindah2(evt,Laborat,Tatalaksana);
    }//GEN-LAST:event_DiagnosisKeyPressed

    private void EKGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EKGKeyPressed
        Valid.pindah2(evt,KetLokalis,Radiologi);
    }//GEN-LAST:event_EKGKeyPressed

    private void KetLokalisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KetLokalisKeyPressed
        Valid.pindah2(evt,KetFisik,EKG);
    }//GEN-LAST:event_KetLokalisKeyPressed

    private void EkstremitasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EkstremitasKeyPressed
        Valid.pindah(evt,Genital,KetFisik);
    }//GEN-LAST:event_EkstremitasKeyPressed

    private void GenitalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GenitalKeyPressed
        Valid.pindah(evt,Abdomen,Ekstremitas);
    }//GEN-LAST:event_GenitalKeyPressed

    private void AbdomenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AbdomenKeyPressed
        Valid.pindah(evt,Thoraks,Genital);
    }//GEN-LAST:event_AbdomenKeyPressed

    private void ThoraksKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ThoraksKeyPressed
        Valid.pindah(evt,Leher,Abdomen);
    }//GEN-LAST:event_ThoraksKeyPressed

    private void LeherKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LeherKeyPressed
        Valid.pindah(evt,Gigi,Thoraks);
    }//GEN-LAST:event_LeherKeyPressed

    private void GigiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GigiKeyPressed
        Valid.pindah(evt,Mata,Leher);
    }//GEN-LAST:event_GigiKeyPressed

    private void KepalaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KepalaKeyPressed
        Valid.pindah(evt,SPO,Mata);
    }//GEN-LAST:event_KepalaKeyPressed

    private void SPOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPOKeyPressed
        Valid.pindah(evt,Suhu,Kepala);
    }//GEN-LAST:event_SPOKeyPressed

    private void KesadaranKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KesadaranKeyPressed
        Valid.pindah(evt,Keadaan,GCS);
    }//GEN-LAST:event_KesadaranKeyPressed

    private void KeadaanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeadaanKeyPressed
        Valid.pindah(evt,Alergi,Kesadaran);
    }//GEN-LAST:event_KeadaanKeyPressed

    private void RPSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RPSKeyPressed
        Valid.pindah2(evt,KeluhanUtama,RPK);
    }//GEN-LAST:event_RPSKeyPressed

    private void GCSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GCSKeyPressed
        Valid.pindah(evt,Kesadaran,TB);
    }//GEN-LAST:event_GCSKeyPressed

    private void KetFisikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KetFisikKeyPressed
        Valid.pindah2(evt,Ekstremitas,KetLokalis);
    }//GEN-LAST:event_KetFisikKeyPressed

    private void RPOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RPOKeyPressed
        Valid.pindah2(evt,RPD,Alergi);
    }//GEN-LAST:event_RPOKeyPressed

    private void RPKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RPKKeyPressed
        Valid.pindah2(evt,RPS,RPD);
    }//GEN-LAST:event_RPKKeyPressed

    private void RPDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RPDKeyPressed
        Valid.pindah2(evt,RPK,RPO);
    }//GEN-LAST:event_RPDKeyPressed

    private void KeluhanUtamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeluhanUtamaKeyPressed
        Valid.pindah2(evt,Hubungan,RPS);
    }//GEN-LAST:event_KeluhanUtamaKeyPressed

    private void AlergiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AlergiKeyPressed
        Valid.pindah(evt,RPO,Keadaan);
    }//GEN-LAST:event_AlergiKeyPressed

    private void RRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RRKeyPressed
        Valid.pindah(evt,Nadi,Suhu);
    }//GEN-LAST:event_RRKeyPressed

    private void TDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TDKeyPressed
        Valid.pindah(evt,BB,Nadi);
    }//GEN-LAST:event_TDKeyPressed

    private void SuhuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SuhuKeyPressed
        Valid.pindah(evt,RR,SPO);
    }//GEN-LAST:event_SuhuKeyPressed

    private void NadiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NadiKeyPressed
        Valid.pindah(evt,TD,RR);
    }//GEN-LAST:event_NadiKeyPressed

    private void TBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBKeyPressed
        Valid.pindah(evt,GCS,BB);
    }//GEN-LAST:event_TBKeyPressed

    private void BBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BBKeyPressed
        Valid.pindah(evt,TB,TD);
    }//GEN-LAST:event_BBKeyPressed

    private void SekunderZonaKuning1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SekunderZonaKuning1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SekunderZonaKuning1ActionPerformed

    private void DTPCari5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DTPCari5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DTPCari5ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            RMTriaseIGDModif1 dialog = new RMTriaseIGDModif1(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.ComboBox Abdomen;
    private widget.ComboBox AlasanKedatangan;
    private widget.TextBox Alergi;
    private widget.ComboBox Anamnesis;
    private widget.TextBox BB;
    private widget.Button BtnAll;
    private widget.Button BtnBatal;
    private widget.Button BtnCari;
    private widget.Button BtnCari2;
    private widget.Button BtnCariPemeriksaan;
    private widget.Button BtnEdit;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnPrint1;
    private widget.Button BtnSimpan;
    private widget.Button BtnTambahPemeriksaan;
    private widget.ComboBox CaraMasuk;
    private widget.CekBox ChkAccor;
    private widget.Tanggal DTPCari1;
    private widget.Tanggal DTPCari2;
    private widget.Tanggal DTPCari5;
    private widget.Tanggal DTPCari6;
    private widget.TextArea Diagnosis;
    private widget.TextArea EKG;
    private widget.ComboBox Ekstremitas;
    private widget.PanelBiasa FormInput;
    private widget.PanelBiasa FormInput1;
    private widget.PanelBiasa FormMenu;
    private widget.InternalFrame FormTriase;
    private widget.TextBox GCS;
    private widget.ComboBox Genital;
    private widget.ComboBox Gigi;
    private widget.TextBox Hubungan;
    private widget.TextBox Jk;
    private widget.TextBox KdKasus;
    private widget.ComboBox Keadaan;
    private widget.TextArea KeluhanUtama;
    private widget.ComboBox Kepala;
    private widget.ComboBox Kesadaran;
    private widget.TextArea KetFisik;
    private widget.TextArea KetLokalis;
    private widget.TextBox KeteranganKedatangan;
    private widget.Label LCount;
    private widget.Label LCount2;
    private widget.TextArea Laborat;
    private widget.ComboBox Leher;
    private widget.editorpane LoadHTML;
    private widget.editorpane LoadHTML2;
    private widget.ComboBox Mata;
    private widget.TextBox Nadi;
    private widget.TextBox NmKasus;
    private widget.PanelBiasa PanelAccor;
    private usu.widget.glass.PanelGlass PanelWall;
    private usu.widget.glass.PanelGlass PanelWall1;
    private widget.TextBox PrimerCatatan;
    private widget.TextArea PrimerKeluhanUtama;
    private widget.TextBox PrimerKodePetugas;
    private widget.RadioButton PrimerKritis;
    private widget.ComboBox PrimerKubutuhanKusus;
    private widget.TextBox PrimerNadi;
    private widget.TextBox PrimerNamaPetugas;
    private widget.TextBox PrimerNyeri;
    private widget.TextBox PrimerRespirasi;
    private widget.RadioButton PrimerResusitasi;
    private widget.TextBox PrimerSaturasi;
    private widget.TextBox PrimerSuhu;
    private widget.Tanggal PrimerTanggalTriase;
    private widget.TextBox PrimerTensi;
    private widget.TextArea RPD;
    private widget.TextArea RPK;
    private widget.TextArea RPO;
    private widget.TextArea RPS;
    private widget.TextBox RR;
    private widget.TextArea Radiologi;
    private widget.TextBox SPO;
    private widget.ScrollPane Scroll;
    private widget.ScrollPane Scroll2;
    private widget.ScrollPane Scroll9;
    private widget.ScrollPane ScrollHTML;
    private widget.ScrollPane ScrollTriase;
    private widget.RadioButton SekunderZonaHijau1;
    private widget.RadioButton SekunderZonaKuning1;
    private widget.TextBox Skalanyeri;
    private widget.TextBox Suhu;
    private widget.TextBox TB;
    private widget.TextBox TCari;
    private widget.TextBox TCari2;
    private widget.TextBox TCariPemeriksaan;
    private widget.TextBox TD;
    private widget.TextBox TNoRM;
    private widget.TextBox TNoRM1;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private widget.TextBox TPasien1;
    private javax.swing.JTabbedPane TabPilihan;
    private javax.swing.JTabbedPane TabTriase;
    private widget.Tanggal TanggalKunjungan;
    private widget.TextArea Tatalaksana;
    private widget.TextBox TglLahir;
    private widget.ComboBox Thoraks;
    private widget.ComboBox Transportasi;
    private widget.Button btnKasus;
    private widget.Button btnPrimerPetugas;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup cairanamnion;
    private widget.CekBox cbPrioritas1;
    private widget.CekBox cbPrioritas2a;
    private widget.CekBox cbPrioritas2b;
    private widget.CekBox cbPrioritas2c;
    private widget.CekBox cbPrioritas3;
    private widget.CekBox cbPrioritas3tidak;
    private widget.ComboBox cbPrioritas543;
    private widget.CekBox cekBox10;
    private widget.CekBox cekBox11;
    private widget.CekBox cekBox12;
    private widget.CekBox cekBox5;
    private widget.CekBox cekBox6;
    private widget.CekBox cekBox7;
    private widget.CekBox cekBox8;
    private widget.CekBox cekBox9;
    private widget.RadioButton cekTidak1;
    private widget.RadioButton cekTidak2;
    private widget.RadioButton cekTidak3;
    private widget.RadioButton cekTidak4;
    private widget.RadioButton cekYa1;
    private widget.RadioButton cekYa2;
    private widget.RadioButton cekYa3;
    private widget.RadioButton cekYa4;
    private widget.ComboBox comboBox1;
    private javax.swing.ButtonGroup cukupbulan;
    private widget.TextBox durasinyeri;
    private widget.TextBox frekuensinyeri;
    private widget.TextBox gambarannyeri;
    private javax.swing.ButtonGroup groupnyeri;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame15;
    private widget.InternalFrame internalFrame2;
    private widget.InternalFrame internalFrame3;
    private widget.InternalFrame internalFrame4;
    private widget.InternalFrame internalFrame5;
    private widget.InternalFrame internalFrame7;
    private widget.InternalFrame internalFrame8;
    private widget.InternalFrame internalFrame9;
    private widget.Label jLabel10;
    private widget.Label jLabel100;
    private widget.Label jLabel101;
    private widget.Label jLabel102;
    private widget.Label jLabel103;
    private widget.Label jLabel11;
    private widget.Label jLabel12;
    private widget.Label jLabel16;
    private widget.Label jLabel18;
    private widget.Label jLabel19;
    private widget.Label jLabel20;
    private widget.Label jLabel21;
    private widget.Label jLabel22;
    private widget.Label jLabel23;
    private widget.Label jLabel24;
    private widget.Label jLabel25;
    private widget.Label jLabel26;
    private widget.Label jLabel27;
    private widget.Label jLabel28;
    private widget.Label jLabel29;
    private widget.Label jLabel34;
    private widget.Label jLabel35;
    private widget.Label jLabel39;
    private widget.Label jLabel4;
    private widget.Label jLabel40;
    private widget.Label jLabel41;
    private widget.Label jLabel42;
    private widget.Label jLabel44;
    private widget.Label jLabel45;
    private widget.Label jLabel46;
    private widget.Label jLabel48;
    private widget.Label jLabel49;
    private widget.Label jLabel5;
    private widget.Label jLabel50;
    private widget.Label jLabel51;
    private widget.Label jLabel52;
    private widget.Label jLabel53;
    private widget.Label jLabel54;
    private widget.Label jLabel55;
    private widget.Label jLabel56;
    private widget.Label jLabel57;
    private widget.Label jLabel58;
    private widget.Label jLabel59;
    private widget.Label jLabel6;
    private widget.Label jLabel60;
    private widget.Label jLabel61;
    private widget.Label jLabel62;
    private widget.Label jLabel63;
    private widget.Label jLabel64;
    private widget.Label jLabel65;
    private widget.Label jLabel66;
    private widget.Label jLabel67;
    private widget.Label jLabel68;
    private widget.Label jLabel69;
    private widget.Label jLabel7;
    private widget.Label jLabel70;
    private widget.Label jLabel71;
    private widget.Label jLabel72;
    private widget.Label jLabel73;
    private widget.Label jLabel74;
    private widget.Label jLabel75;
    private widget.Label jLabel77;
    private widget.Label jLabel78;
    private widget.Label jLabel79;
    private widget.Label jLabel8;
    private widget.Label jLabel80;
    private widget.Label jLabel81;
    private widget.Label jLabel82;
    private widget.Label jLabel83;
    private widget.Label jLabel84;
    private widget.Label jLabel9;
    private widget.Label jLabel94;
    private widget.Label jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private widget.Label label1;
    private widget.Label label10;
    private widget.Label label14;
    private widget.Label label16;
    private widget.Label label17;
    private widget.Label label18;
    private widget.Label label19;
    private widget.Label label2;
    private widget.Label label20;
    private widget.Label label21;
    private widget.Label label22;
    private widget.Label label23;
    private widget.Label label24;
    private widget.Label label25;
    private widget.Label label26;
    private widget.Label label27;
    private widget.Label label28;
    private widget.Label label29;
    private widget.Label label3;
    private widget.Label label4;
    private widget.Label label5;
    private widget.Label label6;
    private widget.Label label7;
    private widget.Label label8;
    private widget.Label label9;
    private widget.TextBox lokasinyeri;
    private widget.panelisi panelGlass11;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private widget.panelisi panelisi1;
    private widget.panelisi panelisi10;
    private widget.panelisi panelisi11;
    private widget.panelisi panelisi12;
    private widget.panelisi panelisi13;
    private widget.panelisi panelisi14;
    private widget.panelisi panelisi15;
    private widget.panelisi panelisi16;
    private widget.panelisi panelisi17;
    private widget.panelisi panelisi18;
    private widget.panelisi panelisi2;
    private widget.panelisi panelisi3;
    private widget.panelisi panelisi4;
    private widget.panelisi panelisi5;
    private widget.panelisi panelisi9;
    private javax.swing.ButtonGroup pernafasan;
    private widget.panelisi prioritas1;
    private widget.panelisi prioritas2;
    private widget.panelisi prioritas3;
    private widget.panelisi prioritas4;
    private widget.ScrollPane scrollInput;
    private widget.ScrollPane scrollPane1;
    private widget.ScrollPane scrollPane10;
    private widget.ScrollPane scrollPane11;
    private widget.ScrollPane scrollPane12;
    private widget.ScrollPane scrollPane13;
    private widget.ScrollPane scrollPane14;
    private widget.ScrollPane scrollPane15;
    private widget.ScrollPane scrollPane3;
    private widget.ScrollPane scrollPane4;
    private widget.ScrollPane scrollPane5;
    private widget.ScrollPane scrollPane6;
    private widget.ScrollPane scrollPane7;
    private widget.ScrollPane scrollPane8;
    private widget.ScrollPane scrollPane9;
    private widget.Table table1;
    private widget.Table tbAwalMedisIGD;
    private widget.Table tbPemeriksaan;
    private widget.Table tbTriase;
    private javax.swing.ButtonGroup tonus;
    // End of variables declaration//GEN-END:variables

    public void tampil() {        
        Valid.tabelKosong(tabMode);
        try{
            ps=koneksi.prepareStatement(
                    "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.tgl_lahir,pasien.jk,pasien.nm_pasien,data_triase_igd.tgl_kunjungan,"+
                    "data_triase_igd.cara_masuk,data_triase_igd.alat_transportasi,data_triase_igd.alasan_kedatangan,"+
                    "data_triase_igd.keterangan_kedatangan,data_triase_igd.kode_kasus,master_triase_macam_kasus.macam_kasus,"
                  + "data_triase_igd.tekanan_darah,data_triase_igd.nadi,data_triase_igd.pernapasan,data_triase_igd.suhu,data_triase_igd.saturasi_o2,data_triase_igd.nyeri,data_triase_igd.keluhan_utama, "
                  + "data_triase_igd.kebutuhan_khusus,data_triase_igd.catatan,data_triase_igd.ESI1,data_triase_igd.ESI2,data_triase_igd.ESI3,data_triase_igd.ESI4,data_triase_igd.ESI5, "
                  + "data_triase_igd.cukupbulan,data_triase_igd.cairanamnion,data_triase_igd.pernafasan,data_triase_igd.tonus,data_triase_igd.isolasi1,data_triase_igd.psikologi,data_triase_igd.nyeritext, "
                  + "data_triase_igd.lokasi,data_triase_igd.durasi,data_triase_igd.frekuensi,data_triase_igd.gambnyeri "+
                    "from reg_periksa inner join pasien inner join data_triase_igd inner join master_triase_macam_kasus "+
                    "on reg_periksa.no_rkm_medis=pasien.no_rkm_medis and reg_periksa.no_rawat=data_triase_igd.no_rawat "+
                    "and data_triase_igd.kode_kasus=master_triase_macam_kasus.kode_kasus "+
                    "where data_triase_igd.tgl_kunjungan between ? and ? and reg_periksa.no_rawat like ? or "+
                    "data_triase_igd.tgl_kunjungan between ? and ? and pasien.no_rkm_medis like ? or "+
                    "data_triase_igd.tgl_kunjungan between ? and ? and pasien.nm_pasien like ? or "+
                    "data_triase_igd.tgl_kunjungan between ? and ? and data_triase_igd.cara_masuk like ? or "+
                    "data_triase_igd.tgl_kunjungan between ? and ? and data_triase_igd.alat_transportasi like ? or "+
                    "data_triase_igd.tgl_kunjungan between ? and ? and data_triase_igd.alasan_kedatangan like ? or "+
                    "data_triase_igd.tgl_kunjungan between ? and ? and data_triase_igd.keterangan_kedatangan like ? or "+
                    "data_triase_igd.tgl_kunjungan between ? and ? and master_triase_macam_kasus.macam_kasus like ? order by data_triase_igd.tgl_kunjungan");
            try {
                ps.setString(1,Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00");
                ps.setString(2,Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59");
                ps.setString(3,"%"+TCari.getText().trim()+"%");
                ps.setString(4,Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00");
                ps.setString(5,Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59");
                ps.setString(6,"%"+TCari.getText().trim()+"%");
                ps.setString(7,Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00");
                ps.setString(8,Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59");
                ps.setString(9,"%"+TCari.getText().trim()+"%");
                ps.setString(10,Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00");
                ps.setString(11,Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59");
                ps.setString(12,"%"+TCari.getText().trim()+"%");
                ps.setString(13,Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00");
                ps.setString(14,Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59");
                ps.setString(15,"%"+TCari.getText().trim()+"%");
                ps.setString(16,Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00");
                ps.setString(17,Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59");
                ps.setString(18,"%"+TCari.getText().trim()+"%");
                ps.setString(19,Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00");
                ps.setString(20,Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59");
                ps.setString(21,"%"+TCari.getText().trim()+"%");
                ps.setString(22,Valid.SetTgl(DTPCari1.getSelectedItem()+"")+" 00:00:00");
                ps.setString(23,Valid.SetTgl(DTPCari2.getSelectedItem()+"")+" 23:59:59");
                ps.setString(24,"%"+TCari.getText().trim()+"%");
                rs=ps.executeQuery();
                while(rs.next()){
                    tabMode.addRow(new String[]{
                        rs.getString("no_rawat"),rs.getString("no_rkm_medis"),rs.getString("nm_pasien"),rs.getString("tgl_kunjungan"),
                        rs.getString("cara_masuk"),rs.getString("alat_transportasi"),rs.getString("alasan_kedatangan"),
                        rs.getString("keterangan_kedatangan"),rs.getString("kode_kasus"),rs.getString("macam_kasus"),
                        rs.getString("tekanan_darah"),rs.getString("nadi"),rs.getString("pernapasan"),rs.getString("suhu"),rs.getString("saturasi_o2"),
                        rs.getString("nyeri"),rs.getString("keluhan_utama"),rs.getString("kebutuhan_khusus"),rs.getString("catatan"),rs.getString("ESI1"),rs.getString("ESI2"),    
                        rs.getString("ESI3"),rs.getString("ESI4"),rs.getString("ESI5"),rs.getString("cukupbulan"),rs.getString("cairanamnion"),rs.getString("pernafasan"),    
                        rs.getString("tonus"),rs.getString("isolasi1"),rs.getString("psikologi"),rs.getString("nyeritext"),rs.getString("lokasi"),rs.getString("durasi"),    
                        rs.getString("frekuensi"),rs.getString("gambnyeri")
                    });
                }
            } catch (Exception e){
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        }catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
        LCount.setText(""+tabMode.getRowCount());
    }
    
    public void tampilawalmedis() {
        Valid.tabelKosong(TabModeAwal);
        try{
            if(TCari.getText().trim().equals("")){
                ps=koneksi.prepareStatement(
                        "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,if(pasien.jk='L','Laki-Laki','Perempuan') as jk,pasien.tgl_lahir,penilaian_medis_igd.tanggal,"+
                        "penilaian_medis_igd.kd_dokter,penilaian_medis_igd.anamnesis,penilaian_medis_igd.hubungan,penilaian_medis_igd.keluhan_utama,penilaian_medis_igd.rps,penilaian_medis_igd.rpk,penilaian_medis_igd.rpd,penilaian_medis_igd.rpo,penilaian_medis_igd.alergi,"+
                        "penilaian_medis_igd.keadaan,penilaian_medis_igd.gcs,penilaian_medis_igd.kesadaran,penilaian_medis_igd.td,penilaian_medis_igd.nadi,penilaian_medis_igd.rr,penilaian_medis_igd.suhu,penilaian_medis_igd.spo,penilaian_medis_igd.bb,penilaian_medis_igd.tb,"+
                        "penilaian_medis_igd.kepala,penilaian_medis_igd.mata,penilaian_medis_igd.gigi,penilaian_medis_igd.leher,penilaian_medis_igd.thoraks,penilaian_medis_igd.abdomen,penilaian_medis_igd.ekstremitas,penilaian_medis_igd.genital,penilaian_medis_igd.ket_fisik,"+
                        "penilaian_medis_igd.ket_lokalis,penilaian_medis_igd.ekg,penilaian_medis_igd.rad,penilaian_medis_igd.lab,penilaian_medis_igd.diagnosis,penilaian_medis_igd.tata,dokter.nm_dokter "+
                        "from reg_periksa inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                        "inner join penilaian_medis_igd on reg_periksa.no_rawat=penilaian_medis_igd.no_rawat "+
                        "inner join dokter on penilaian_medis_igd.kd_dokter=dokter.kd_dokter where "+
                        "penilaian_medis_igd.tanggal between ? and ? order by penilaian_medis_igd.tanggal");
            }else{
                ps=koneksi.prepareStatement(
                        "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,if(pasien.jk='L','Laki-Laki','Perempuan') as jk,pasien.tgl_lahir,penilaian_medis_igd.tanggal,"+
                        "penilaian_medis_igd.kd_dokter,penilaian_medis_igd.anamnesis,penilaian_medis_igd.hubungan,penilaian_medis_igd.keluhan_utama,penilaian_medis_igd.rps,penilaian_medis_igd.rpk,penilaian_medis_igd.rpd,penilaian_medis_igd.rpo,penilaian_medis_igd.alergi,"+
                        "penilaian_medis_igd.keadaan,penilaian_medis_igd.gcs,penilaian_medis_igd.kesadaran,penilaian_medis_igd.td,penilaian_medis_igd.nadi,penilaian_medis_igd.rr,penilaian_medis_igd.suhu,penilaian_medis_igd.spo,penilaian_medis_igd.bb,penilaian_medis_igd.tb,"+
                        "penilaian_medis_igd.kepala,penilaian_medis_igd.mata,penilaian_medis_igd.gigi,penilaian_medis_igd.leher,penilaian_medis_igd.thoraks,penilaian_medis_igd.abdomen,penilaian_medis_igd.ekstremitas,penilaian_medis_igd.genital,penilaian_medis_igd.ket_fisik,"+
                        "penilaian_medis_igd.ket_lokalis,penilaian_medis_igd.ekg,penilaian_medis_igd.rad,penilaian_medis_igd.lab,penilaian_medis_igd.diagnosis,penilaian_medis_igd.tata,dokter.nm_dokter "+
                        "from reg_periksa inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                        "inner join penilaian_medis_igd on reg_periksa.no_rawat=penilaian_medis_igd.no_rawat "+
                        "inner join dokter on penilaian_medis_igd.kd_dokter=dokter.kd_dokter where "+
                        "penilaian_medis_igd.tanggal between ? and ? and (reg_periksa.no_rawat like ? or pasien.no_rkm_medis like ? or pasien.nm_pasien like ? or "+
                        "penilaian_medis_igd.kd_dokter like ? or dokter.nm_dokter like ?) order by penilaian_medis_igd.tanggal");
            }
                
            try {
                if(TCari.getText().trim().equals("")){
                    ps.setString(1,Valid.SetTgl(DTPCari5.getSelectedItem()+"")+" 00:00:00");
                    ps.setString(2,Valid.SetTgl(DTPCari6.getSelectedItem()+"")+" 23:59:59");
                }else{
                    ps.setString(1,Valid.SetTgl(DTPCari5.getSelectedItem()+"")+" 00:00:00");
                    ps.setString(2,Valid.SetTgl(DTPCari6.getSelectedItem()+"")+" 23:59:59");
                    ps.setString(3,"%"+TCari.getText()+"%");
                    ps.setString(4,"%"+TCari.getText()+"%");
                    ps.setString(5,"%"+TCari.getText()+"%");
                    ps.setString(6,"%"+TCari.getText()+"%");
                    ps.setString(7,"%"+TCari.getText()+"%");
                }   
                rs=ps.executeQuery();
                while(rs.next()){
                    TabModeAwal.addRow(new String[]{
                        rs.getString("no_rawat"),rs.getString("no_rkm_medis"),rs.getString("nm_pasien"),rs.getString("tgl_lahir"),rs.getString("jk"),rs.getString("kd_dokter"),rs.getString("nm_dokter"),rs.getString("tanggal"),
                        rs.getString("anamnesis"),rs.getString("hubungan"),rs.getString("keluhan_utama"),rs.getString("rps"),rs.getString("rpd"),rs.getString("rpk"),rs.getString("rpo"),rs.getString("alergi"),
                        rs.getString("keadaan"),rs.getString("gcs"),rs.getString("kesadaran"),rs.getString("td"),rs.getString("nadi"),rs.getString("rr"),rs.getString("suhu"),rs.getString("spo"),rs.getString("bb"),
                        rs.getString("tb"),rs.getString("kepala"),rs.getString("mata"),rs.getString("gigi"),rs.getString("leher"),rs.getString("thoraks"),rs.getString("abdomen"),rs.getString("genital"),
                        rs.getString("ekstremitas"),rs.getString("ket_fisik"),rs.getString("ket_lokalis"),rs.getString("ekg"),rs.getString("rad"),rs.getString("lab"),rs.getString("diagnosis"),rs.getString("tata")
                    });
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
            
        }catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
        LCount.setText(""+TabModeAwal.getRowCount());
    }
    
    private void emptTeks(){
        TNoRw.setText("");
        TPasien.setText("");
        TNoRM.setText("");
        Transportasi.setSelectedIndex(0);
        TanggalKunjungan.setDate(new Date());
        AlasanKedatangan.setSelectedIndex(0);
        KdKasus.setText("");
        NmKasus.setText("");
        CaraMasuk.setSelectedIndex(0);
        KeteranganKedatangan.setText("");
        PrimerKeluhanUtama.setText("");
        PrimerSuhu.setText("");
        PrimerNyeri.setText("");
        PrimerTensi.setText("");
        PrimerNadi.setText("");
        PrimerSaturasi.setText("");
        PrimerRespirasi.setText("");
        PrimerKubutuhanKusus.setSelectedIndex(0);
        PrimerCatatan.setText("");
        PrimerTanggalTriase.setDate(new Date());

        TabPilihan.setSelectedIndex(0);
        TabTriase.setSelectedIndex(0);
        Transportasi.requestFocus();
        
        
        Anamnesis.setSelectedIndex(0);
        Hubungan.setText("");
        KeluhanUtama.setText("");
        RPS.setText("");
        RPK.setText("");
        RPD.setText("");
        RPO.setText("");
        Alergi.setText("");
        Keadaan.setSelectedIndex(0);
        GCS.setText("");
        Kesadaran.setSelectedIndex(0);
        TD.setText("");
        Nadi.setText("");
        RR.setText("");
        Suhu.setText("");
        BB.setText("");
        TB.setText("");
        Kepala.setSelectedIndex(0);
        Mata.setSelectedIndex(0);
        Gigi.setSelectedIndex(0);
        Leher.setSelectedIndex(0);
        Thoraks.setSelectedIndex(0);
        Abdomen.setSelectedIndex(0);
        Genital.setSelectedIndex(0);
        Ekstremitas.setSelectedIndex(0);
        KetFisik.setText("");
        KetLokalis.setText("");
        EKG.setText("");
        Radiologi.setText("");
        Laborat.setText("");
        Diagnosis.setText("");
        Tatalaksana.setText("");
        Anamnesis.requestFocus();
        lokasinyeri.setText("");
        frekuensinyeri.setText("");
        durasinyeri.setText("");
        gambarannyeri.setText("");
        cekBox10.setSelected(false);
        cekBox11.setSelected(false);
        cekBox12.setSelected(false);
        cekBox5.setSelected(false);
        cekBox6.setSelected(false);
        cekBox7.setSelected(false);
        cekBox8.setSelected(false);
        cekBox9.setSelected(false);
        cbPrioritas1.setSelected(false);
        cbPrioritas2a.setSelected(false);
        cbPrioritas2b.setSelected(false);
        cbPrioritas2c.setSelected(false);
        cbPrioritas3.setSelected(false);
        cbPrioritas3tidak.setSelected(false);
    }
    
    public void setNoRm(String norwt,String norm,String namapasien) {
        emptTeks();
        TNoRw.setText(norwt);
        TNoRM.setText(norm);
        TPasien.setText(namapasien);
        TglLahir.setText(Sequel.cariIsi("select tgl_lahir from pasien where no_rkm_medis='"+norm+"'"));
        Jk.setText(Sequel.cariIsi("select jk from pasien where no_rkm_medis='"+norm+"'"));
        TCari.setText(norwt);  
        TCari2.setText(norwt);  
    }
    
    public void tampilPemeriksaan() {        
        Valid.tabelKosong(tabModePemeriksaan);
        try{
            ps=koneksi.prepareStatement("select * from master_triase_pemeriksaan where kode_pemeriksaan like ? or nama_pemeriksaan like ? order by kode_pemeriksaan");
            try {
                ps.setString(1,"%"+TCariPemeriksaan.getText().trim()+"%");
                ps.setString(2,"%"+TCariPemeriksaan.getText().trim()+"%");
                rs=ps.executeQuery();
                while(rs.next()){
                    tabModePemeriksaan.addRow(new String[]{rs.getString(1),rs.getString(2)});
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        }catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
    }
    
    

    public void isCek(){
        BtnSimpan.setEnabled(akses.getdata_triase_igd());
        BtnHapus.setEnabled(akses.getdata_triase_igd());
        BtnPrint.setEnabled(akses.getdata_triase_igd());
        BtnEdit.setEnabled(akses.getdata_triase_igd());  
        BtnTambahPemeriksaan.setEnabled(akses.getmaster_triase_pemeriksaan());
        
        
        if(akses.getjml2()>=1){
            btnPrimerPetugas.setEnabled(false);
            PrimerKodePetugas.setText(akses.getkode());
            Sequel.cariIsi("select nama from pegawai where nik=?", PrimerNamaPetugas,PrimerKodePetugas.getText());
            
        } 
    }
    
    private void getData() {
        if(tbTriase.getSelectedRow()!= -1){
            try {
                //Form
                
                TNoRw.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(),0).toString());
                TNoRM.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(),1).toString());
                TPasien.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(),2).toString());
                Valid.SetTgl2(TanggalKunjungan,tbTriase.getValueAt(tbTriase.getSelectedRow(),3).toString());
                CaraMasuk.setSelectedItem(tbTriase.getValueAt(tbTriase.getSelectedRow(),4).toString());
                Transportasi.setSelectedItem(tbTriase.getValueAt(tbTriase.getSelectedRow(),5).toString());
                AlasanKedatangan.setSelectedItem(tbTriase.getValueAt(tbTriase.getSelectedRow(),6).toString());
                KeteranganKedatangan.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(),7).toString());
                KdKasus.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(), 8).toString());
                NmKasus.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(), 9).toString());
                PrimerTensi.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(), 10).toString());
                PrimerNadi.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(), 11).toString());
                PrimerRespirasi.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(), 12).toString());
                PrimerSuhu.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(), 13).toString());
                PrimerSaturasi.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(), 14).toString());
                PrimerNyeri.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(), 15).toString());
                PrimerKeluhanUtama.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(), 16).toString());
                
                // Reset Prioritas
                cbPrioritas1.setSelected(false);
                cbPrioritas2a.setSelected(false);
                cbPrioritas2b.setSelected(false);
                cbPrioritas2c.setSelected(false);
                cbPrioritas3.setSelected(false);
                cbPrioritas3tidak.setSelected(false);
                cbPrioritas543.setSelectedIndex(0);
                
                if(tbTriase.getValueAt(tbTriase.getSelectedRow(),19).toString().equals("PERLU TINDAKAN LIVE SAVING / RESUSITASI SEGERA")){
                   cbPrioritas1.setSelected(true);
                }
                
                if(tbTriase.getValueAt(tbTriase.getSelectedRow(),20).toString().equals("KEBINGUNGAN / LETARGIS ? DISORIENTASI")){
                   cbPrioritas2a.setSelected(true);
                }else if(tbTriase.getValueAt(tbTriase.getSelectedRow(),20).toString().equals("RISIKO TINGGI")){
                   cbPrioritas2b.setSelected(true);
                }else if(tbTriase.getValueAt(tbTriase.getSelectedRow(),20).toString().equals("NYERI / DISTRES BERAT")){
                   cbPrioritas2c.setSelected(true);
                }
                
                if(tbTriase.getValueAt(tbTriase.getSelectedRow(),23).toString().equals("TIDAK ADA")){
                    cbPrioritas543.setSelectedIndex(1);
                }else if(tbTriase.getValueAt(tbTriase.getSelectedRow(),22).toString().equals("SATU")){
                    cbPrioritas543.setSelectedIndex(2);
                }else if(tbTriase.getValueAt(tbTriase.getSelectedRow(),21).toString().contains("BANYAK (>2)")){
                    cbPrioritas543.setSelectedIndex(3);
                    if(tbTriase.getValueAt(tbTriase.getSelectedRow(),21).toString().contains("- Ya")) {
                        cbPrioritas3.setSelected(true);
                    } else if(tbTriase.getValueAt(tbTriase.getSelectedRow(),21).toString().contains("- Tidak")) {
                        cbPrioritas3tidak.setSelected(true);
                        hitungPrioritas2b();
                    }
                }else {
                    cbPrioritas543.setSelectedIndex(0);
                
                }
                String valCukupBulan = tbTriase.getValueAt(tbTriase.getSelectedRow(), 24).toString();
                if(valCukupBulan.equals("Ya")) {
                    cekYa1.setSelected(true);
                } else if(valCukupBulan.equals("Tidak")) {
                    cekTidak1.setSelected(true);
                } else {
                    cukupbulan.clearSelection(); 
                }
                String valAmnion = tbTriase.getValueAt(tbTriase.getSelectedRow(), 25).toString();
                if(valAmnion.equals("Ya")) {
                    cekYa2.setSelected(true);
                } else if(valAmnion.equals("Tidak")) {
                    cekTidak2.setSelected(true);
                } else {
                    cairanamnion.clearSelection(); 
                }
                String valPernafasan = tbTriase.getValueAt(tbTriase.getSelectedRow(), 26).toString();
                if(valPernafasan.equals("Ya")) {
                    cekYa3.setSelected(true);
                } else if(valPernafasan.equals("Tidak")) {
                    cekTidak3.setSelected(true);
                } else {
                    pernafasan.clearSelection(); 
                }
                String valTonus = tbTriase.getValueAt(tbTriase.getSelectedRow(), 27).toString();
                if(valTonus.equals("Ya")) {
                    cekYa4.setSelected(true);
                } else if(valTonus.equals("Tidak")) {
                    cekTidak4.setSelected(true);
                } else {
                    tonus.clearSelection();
                }
                setNilaiIsolasi(tbTriase.getValueAt(tbTriase.getSelectedRow(),28).toString());
                setPsikologi(tbTriase.getValueAt(tbTriase.getSelectedRow(),29).toString());
                lokasinyeri.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(),31).toString());
                durasinyeri.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(),32).toString());
                frekuensinyeri.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(),33).toString());
                gambarannyeri.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(),34).toString());
                
                hitungPrioritas1();
                hitungPrioritas2();
                hitungPrioritas3();
                
                //panel HTML
                TNoRM1.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(),1).toString());
                TPasien1.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(),2).toString());
                
                ps=koneksi.prepareStatement(
                    "select data_triase_igdprimer.keluhan_utama,data_triase_igdprimer.kebutuhan_khusus,data_triase_igdprimer.catatan,"+
                    "data_triase_igdprimer.plan,data_triase_igdprimer.tanggaltriase,data_triase_igdprimer.nik,data_triase_igd.tekanan_darah,"+
                    "data_triase_igd.nadi,data_triase_igd.pernapasan,data_triase_igd.suhu,data_triase_igd.saturasi_o2,data_triase_igd.nyeri,"+
                    "data_triase_igd.no_rawat,data_triase_igd.lokasi,data_triase_igd.durasi,data_triase_igd.frekuensi,data_triase_igd.gambnyeri,data_triase_igd.ESI1 from data_triase_igdprimer inner join data_triase_igd on data_triase_igd.no_rawat="+
                    "data_triase_igdprimer.no_rawat where data_triase_igd.no_rawat=?");
                try {
                    ps.setString(1,tbTriase.getValueAt(tbTriase.getSelectedRow(),0).toString());
                    rs=ps.executeQuery();
                    if(rs.next()){
                        // ---- Set Nilai Lanjutan ke Form Input ----
                        PrimerKeluhanUtama.setText(rs.getString("keluhan_utama"));
                        PrimerSuhu.setText(rs.getString("suhu"));
                        PrimerNyeri.setText(rs.getString("nyeri"));
                        PrimerTensi.setText(rs.getString("tekanan_darah"));
                        PrimerNadi.setText(rs.getString("nadi"));
                        PrimerSaturasi.setText(rs.getString("saturasi_o2"));
                        PrimerRespirasi.setText(rs.getString("pernapasan"));
                        PrimerKubutuhanKusus.setSelectedItem(rs.getString("kebutuhan_khusus"));
                        
                        if(rs.getString("ESI1").equals("PERLU TINDAKAN LIVE SAVING / RESUSITASI SEGERA")){
                            cbPrioritas1.setSelected(true);
                        }
                        
                        // Reset Checkbox/Radio Plan
                        PrimerResusitasi.setSelected(false);
                        PrimerKritis.setSelected(false);
                        SekunderZonaKuning1.setSelected(false);
                        SekunderZonaHijau1.setSelected(false);
                        
                        if(rs.getString("plan").equals("Ruang Resusitasi")){
                            PrimerResusitasi.setSelected(true);
                        }else if(rs.getString("plan").equals("Ruang Kritis")){
                            PrimerKritis.setSelected(true);
                        }else if(rs.getString("plan").equals("Zona Kuning")){
                            SekunderZonaKuning1.setSelected(true);
                        }else if(rs.getString("plan").equals("Zona Hijau")){
                            SekunderZonaHijau1.setSelected(true);
                        }

                        PrimerTanggalTriase.setDate(new Date());
                        PrimerCatatan.setText(rs.getString("catatan"));
                        PrimerKodePetugas.setText(rs.getString("nik"));
                        PrimerNamaPetugas.setText(Sequel.cariIsi("select nama from pegawai where nik=?",rs.getString("nik")));

                        //html
                        kodepetugas=rs.getString("nik");
                        htmlContent = new StringBuilder();
                        htmlContent.append(    
                            "<tr class='isi'>"+
                                "<td valign='middle' bgcolor='#FFFAF8' align='center' width='35%'>Keterangan</td>"+
                                "<td valign='middle' bgcolor='#FFFAF8' align='center' width='65%'>Triase Primer</td>"+
                            "</tr>"+
                            "<tr class='isi'>"+
                                "<td valign='middle'>Keluhan Utama</td>"+
                                "<td valign='middle'>"+rs.getString("keluhan_utama").replaceAll("(\r\n|\r|\n|\n\r)","<br>")+"</td>"+
                            "</tr>"+
                            "<tr class='isi'>"+
                                "<td valign='middle'>Tanda Vital</td>"+
                                "<td valign='middle'>Suhu (C) : "+rs.getString("suhu")+", Nyeri : "+rs.getString("nyeri")+", Tensi : "+rs.getString("tekanan_darah")+", Nadi(/menit) : "+rs.getString("nadi")+", Saturasi O²(%) : "+rs.getString("saturasi_o2")+", Respirasi(/menit) : "+rs.getString("pernapasan")+"</td>"+
                            "</tr>"+
                            "<tr class='isi'>"+
                                "<td valign='middle'>Kebutuhan Khusus</td>"+
                                "<td valign='middle'>"+rs.getString("kebutuhan_khusus")+"</td>"+
                            "</tr>"
                        );
                        
                        if(rs.getString("plan").equals("Zona Hijau")){
                            keputusan = "#00AA00";
                        }else if(rs.getString("plan").equals("Zona Kuning")){
                            keputusan = "#C8C800";
                        }else if(rs.getString("plan").equals("Ruang Kritis")){
                            keputusan = "#AA0000";
                        }else if(rs.getString("plan").equals("Ruang Resusitasi")){
                            keputusan = "#FF0000";
                        }
                        
                        htmlContent.append(    
                            "<tr class='isi'>"+
                                "<td valign='middle'>Plan/Keputusan</td>"+
                                "<td valign='middle' bgcolor='"+keputusan+"' color='ffffff'>"+rs.getString("plan")+"</td>"+
                            "</tr>"
                        );
                        htmlContent.append(                             
                            "<tr class='isi'>"+
                                "<td valign='middle'>&nbsp;</td>"+
                                "<td valign='middle' bgcolor='#FFFAF8' align='center'>Dokter/Petugas Triase</td>"+
                            "</tr>"+
                            "<tr class='isi'>"+
                                "<td valign='middle'>Tanggal & Jam</td>"+
                                "<td valign='middle'>"+rs.getString("tanggaltriase")+"</td>"+
                            "</tr>"+
                            "<tr class='isi'>"+
                                "<td valign='middle'>Catatan</td>"+
                                "<td valign='middle'>"+rs.getString("catatan")+"</td>"+
                            "</tr>"+
                            "<tr class='isi'>"+
                                "<td valign='middle'>Nama Dokter/Petugas</td>"+
                                "<td valign='middle'>"+rs.getString("nik")+" "+Sequel.cariIsi("select pegawai.nama from pegawai where pegawai.nik=?",rs.getString("nik"))+"</td>"+
                            "</tr>"
                        );
                        
                        LoadHTML.setText(
                            "<html>"+
                              "<table width='100%' border='0' align='center' cellpadding='3px' cellspacing='0' class='tbl_form'>"+
                               htmlContent.toString()+
                              "</table>"+
                            "</html>");
                    }
                } catch (Exception e) {
                    System.out.println("Notifikasi : "+e);
                } finally{
                    if(rs!=null){ rs.close(); }
                    if(ps!=null){ ps.close(); }
                }

                // ==============================================================
                // 3. BAGIAN MENGAMBIL TABEL DETAIL CHECKBOX (JIKA DIPERLUKAN)
                // ==============================================================
                TabTriase.setSelectedIndex(0);
                ps2=koneksi.prepareStatement(
                    "select master_triase_pemeriksaan.kode_pemeriksaan,master_triase_pemeriksaan.nama_pemeriksaan "+
                    "from master_triase_pemeriksaan inner join master_triase_skala1 inner join data_triase_igddetail_skala1 "+
                    "on master_triase_pemeriksaan.kode_pemeriksaan=master_triase_skala1.kode_pemeriksaan and "+
                    "master_triase_skala1.kode_skala1=data_triase_igddetail_skala1.kode_skala1 where data_triase_igddetail_skala1.no_rawat=? "+
                    "group by master_triase_pemeriksaan.kode_pemeriksaan order by master_triase_pemeriksaan.kode_pemeriksaan");
                try {
                    ps2.setString(1,tbTriase.getValueAt(tbTriase.getSelectedRow(),0).toString());
                    rs2=ps2.executeQuery();
                    if(rs2.next()){
                        Valid.tabelKosong(tabModePemeriksaan);
                        Valid.tabelKosong(tabModeSkala1);
                        rs2.beforeFirst();
                        while(rs2.next()){
                            tabModePemeriksaan.addRow(new String[]{rs2.getString("kode_pemeriksaan"),rs2.getString("nama_pemeriksaan")});
                            ps3=koneksi.prepareStatement(
                                "select master_triase_skala1.kode_skala1,master_triase_skala1.pengkajian_skala1 from master_triase_skala1 inner join data_triase_igddetail_skala1 "+
                                "on master_triase_skala1.kode_skala1=data_triase_igddetail_skala1.kode_skala1 where "+
                                "master_triase_skala1.kode_pemeriksaan=? and data_triase_igddetail_skala1.no_rawat=? "+
                                "order by data_triase_igddetail_skala1.kode_skala1");
                            try {
                                ps3.setString(1,rs2.getString("kode_pemeriksaan"));
                                ps3.setString(2,tbTriase.getValueAt(tbTriase.getSelectedRow(),0).toString());
                                rs3=ps3.executeQuery();
                                while(rs3.next()){
                                    tabModeSkala1.addRow(new Object[]{true,rs3.getString("kode_skala1"),rs3.getString("pengkajian_skala1")});
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs3!=null){ rs3.close(); }
                                if(ps3!=null){ ps3.close(); }
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Notif : "+e);
                } finally{
                    if(rs2!=null){ rs2.close(); }
                    if(ps2!=null){ ps2.close(); }
                }

            } catch (Exception e) {
                System.out.println("Notif : "+e);
            }
        }
    }
    private void getData1() {
        if(tbTriase.getSelectedRow()!= -1){
            try {
                TNoRM1.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(),1).toString());
                TPasien1.setText(tbTriase.getValueAt(tbTriase.getSelectedRow(),2).toString());
                ps=koneksi.prepareStatement(
                        "select data_triase_igdprimer.keluhan_utama,data_triase_igdprimer.kebutuhan_khusus,data_triase_igdprimer.catatan,"+
                        "data_triase_igdprimer.plan,data_triase_igdprimer.tanggaltriase,data_triase_igdprimer.nik,data_triase_igd.tekanan_darah,"+
                        "data_triase_igd.nadi,data_triase_igd.pernapasan,data_triase_igd.suhu,data_triase_igd.saturasi_o2,data_triase_igd.nyeri,"+
                        "data_triase_igd.no_rawat from data_triase_igdprimer inner join data_triase_igd on data_triase_igd.no_rawat="+
                        "data_triase_igdprimer.no_rawat where data_triase_igd.no_rawat=?");
                try {
                    ps.setString(1,tbTriase.getValueAt(tbTriase.getSelectedRow(),0).toString());
                    rs=ps.executeQuery();
                    if(rs.next()){
                        kodepetugas=rs.getString("nik");
                        htmlContent = new StringBuilder();
                        htmlContent.append(    
                            "<tr class='isi'>"+
                                "<td valign='middle' bgcolor='#FFFAF8' align='center' width='35%'>Keterangan</td>"+
                                "<td valign='middle' bgcolor='#FFFAF8' align='center' width='65%'>Triase Primer</td>"+
                            "</tr>"+
                            "<tr class='isi'>"+
                                "<td valign='middle'>Keluhan Utama</td>"+
                                "<td valign='middle'>"+rs.getString("keluhan_utama").replaceAll("(\r\n|\r|\n|\n\r)","<br>")+"</td>"+
                            "</tr>"+
                            "<tr class='isi'>"+
                                "<td valign='middle'>Tanda Vital</td>"+
                                "<td valign='middle'>Suhu (C) : "+rs.getString("suhu")+", Nyeri : "+rs.getString("nyeri")+", Tensi : "+rs.getString("tekanan_darah")+", Nadi(/menit) : "+rs.getString("nadi")+", Saturasi O²(%) : "+rs.getString("saturasi_o2")+", Respirasi(/menit) : "+rs.getString("pernapasan")+"</td>"+
                            "</tr>"+
                            "<tr class='isi'>"+
                                "<td valign='middle'>Kebutuhan Khusus</td>"+
                                "<td valign='middle'>"+rs.getString("kebutuhan_khusus")+"</td>"+
                            "</tr>"
                        );
                        
                        
                        if(rs.getString("plan").equals("Zona Hijau")){
                            keputusan = "#00AA00";
                        }else if(rs.getString("plan").equals("Zona Kuning")){
                            keputusan = "#C8C800";
                        }else if(rs.getString("plan").equals("Ruang Kritis")){
                            keputusan = "#AA0000";
                        }else if(rs.getString("plan").equals("Ruang Resusitasi")){
                            keputusan = "#FF0000";
                        }
                        
                        
                        htmlContent.append(    
                            "<tr class='isi'>"+
                                "<td valign='middle'>Plan/Keputusan</td>"+
                                "<td valign='middle' bgcolor='"+keputusan+"' color='ffffff'>"+rs.getString("plan")+"</td>"+
                            "</tr>"
                        );
                        htmlContent.append(                             
                            "<tr class='isi'>"+
                                "<td valign='middle'>&nbsp;</td>"+
                                "<td valign='middle' bgcolor='#FFFAF8' align='center'>Dokter/Petugas Triase</td>"+
                            "</tr>"+
                            "<tr class='isi'>"+
                                "<td valign='middle'>Tanggal & Jam</td>"+
                                "<td valign='middle'>"+rs.getString("tanggaltriase")+"</td>"+
                            "</tr>"+
                            "<tr class='isi'>"+
                                "<td valign='middle'>Catatan</td>"+
                                "<td valign='middle'>"+rs.getString("catatan")+"</td>"+
                            "</tr>"+
                            "<tr class='isi'>"+
                                "<td valign='middle'>Nama Dokter/Petugas</td>"+
                                "<td valign='middle'>"+rs.getString("nik")+" "+Sequel.cariIsi("select pegawai.nama from pegawai where pegawai.nik=?",rs.getString("nik"))+"</td>"+
                            "</tr>"
                        );
                        
                        LoadHTML.setText(
                            "<html>"+
                              "<table width='100%' border='0' align='center' cellpadding='3px' cellspacing='0' class='tbl_form'>"+
                               htmlContent.toString()+
                              "</table>"+
                            "</html>");
                    }
                } catch (Exception e) {
                    System.out.println("Notifikasi : "+e);
                } finally{
                    if(rs!=null){
                        rs.close();
                    }
                    if(ps!=null){
                        ps.close();
                    }
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } 
        }
    }
    

    
    private void getData2() {
        if(tbAwalMedisIGD.getSelectedRow()!= -1){
            TNoRw.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),0).toString()); 
            TNoRM.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),1).toString());
            TPasien.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),2).toString());
            TglLahir.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),3).toString());
            Jk.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),4).toString()); 
            PrimerKodePetugas.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),5).toString());
            PrimerNamaPetugas.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),6).toString());
            
            Anamnesis.setSelectedItem(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),8).toString());
            Hubungan.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),9).toString());
            KeluhanUtama.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),10).toString());
            RPS.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),11).toString());
            RPD.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),12).toString());
            RPK.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),13).toString());
            RPO.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),14).toString());
            Alergi.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),15).toString());
            Keadaan.setSelectedItem(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),16).toString());
            GCS.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),17).toString());
            Kesadaran.setSelectedItem(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),18).toString());
            TD.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),19).toString());
            Nadi.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),20).toString());
            RR.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),21).toString());
            Suhu.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),22).toString());
            SPO.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),23).toString());
            BB.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),24).toString());
            TB.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),25).toString());
            Kepala.setSelectedItem(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),26).toString());
            Mata.setSelectedItem(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),27).toString());
            Gigi.setSelectedItem(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),28).toString());
            Leher.setSelectedItem(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),29).toString());
            Thoraks.setSelectedItem(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),30).toString());
            Abdomen.setSelectedItem(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),31).toString());
            Genital.setSelectedItem(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),32).toString());
            Ekstremitas.setSelectedItem(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),33).toString());
            KetFisik.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),34).toString());
            KetLokalis.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),35).toString());
            EKG.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),36).toString());
            Radiologi.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),37).toString());
            Laborat.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),38).toString());
            Diagnosis.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),39).toString());
            Tatalaksana.setText(tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),40).toString());
            Valid.SetTgl2(TanggalKunjungan,tbAwalMedisIGD.getValueAt(tbAwalMedisIGD.getSelectedRow(),7).toString());
        }
    }
    
    private void isMenu(){
        if(ChkAccor.isSelected()==true){
            ChkAccor.setVisible(false);
            PanelAccor.setPreferredSize(new Dimension(470,HEIGHT));
            FormMenu.setVisible(true);  
            ScrollHTML.setVisible(true);  
            ChkAccor.setVisible(true);
        }else if(ChkAccor.isSelected()==false){   
            ChkAccor.setVisible(false);
            PanelAccor.setPreferredSize(new Dimension(15,HEIGHT));
            FormMenu.setVisible(false);  
            ScrollHTML.setVisible(false);
            ChkAccor.setVisible(true);
            
        }
    }
    
    private void hitungPrioritas1(){
        prioritas1.setVisible(false);
        prioritas2.setVisible(false);
        prioritas3.setVisible(false);
        prioritas4.setVisible(false);
      if(cbPrioritas1.isSelected()==true){
          prioritas1.setVisible(true);
      }else if(cbPrioritas1.isSelected()==false){
          prioritas1.setVisible(false);
      }        
    }
    
    private void hitungPrioritas2(){
        prioritas1.setVisible(false);
        prioritas2.setVisible(false);
        prioritas3.setVisible(false);
        prioritas4.setVisible(false);
      if(cbPrioritas2a.isSelected()==true || cbPrioritas2b.isSelected()==true || cbPrioritas2c.isSelected()==true ){
          prioritas1.setVisible(true);
      }else if(cbPrioritas2a.isSelected()==false || cbPrioritas2b.isSelected()==false || cbPrioritas2c.isSelected()==false){
          prioritas1.setVisible(false);
      }        
    }
    
     private void hitungPrioritas2b() {
        prioritas1.setVisible(false);
        prioritas2.setVisible(false);
        prioritas3.setVisible(false);
        prioritas4.setVisible(false);
        if (cbPrioritas3tidak.isSelected() == true) {
            prioritas2.setVisible(true);
        } else if (cbPrioritas3tidak.isSelected() == false) {
            prioritas2.setVisible(false);
        }
    }
    private void hitungPrioritas3(){
        prioritas1.setVisible(false);
        prioritas2.setVisible(false);
        prioritas3.setVisible(false);
        prioritas4.setVisible(false);
        switch (cbPrioritas543.getSelectedIndex()) {
            case 1:
                prioritas3.setVisible(true);
            break;
            case 2:
                prioritas3.setVisible(true);
            break;   
                 
        }
 
    }
    
    private void kriteriaisolasi(){
        if(cekBox9.isSelected()==true ||cekBox7.isSelected()==true || cekBox8.isSelected()==true ||cekBox5.isSelected()==true){
            prioritas4.setVisible(true);
        }else{
            prioritas4.setVisible(false);
        }
    }
    
    private void getNIlaiisolasi(){
        if(cekBox9.isSelected()==true){
            getIsolasi = cekBox9.getText();
        }else if(cekBox7.isSelected()==true){
            getIsolasi = cekBox7.getText();
        }else if(cekBox8.isSelected()==true){
            getIsolasi = cekBox8.getText();
        }else if(cekBox5.isSelected()==true){
            getIsolasi = cekBox5.getText();   
        }else{
            getIsolasi ="-";
            
        }
    }
    
    private void setNilaiIsolasi(String value){
       
        cekBox9.setSelected(false);
        cekBox7.setSelected(false);
        cekBox8.setSelected(false);
        cekBox5.setSelected(false);

    if(value.equals(cekBox9.getText())){
        cekBox9.setSelected(true);
    }else if(value.equals(cekBox7.getText())){
        cekBox7.setSelected(true);
    }else if(value.equals(cekBox8.getText())){
        cekBox8.setSelected(true);
    }else if(value.equals(cekBox5.getText())){
        cekBox5.setSelected(true);
    }
}
    private void getPsikologi(){
        if(cekBox10.isSelected()==true){
            getPsikologi = cekBox10.getText();
        }else if(cekBox11.isSelected()==true){
            getPsikologi=cekBox11.getText();
        }else if(cekBox12.isSelected()==true){
            getPsikologi=cekBox12.getText();
        }else if(cekBox6.isSelected()==true){
            getPsikologi=cekBox6.getText(); 
        }else{
            getPsikologi ="-";
            
        }
        
    }
    
     private void setPsikologi(String value){
       
        cekBox10.setSelected(false);
        cekBox11.setSelected(false);
        cekBox12.setSelected(false);
        cekBox6.setSelected(false);

    if(value.equals(cekBox10.getText())){
        cekBox10.setSelected(true);
    }else if(value.equals(cekBox11.getText())){
        cekBox11.setSelected(true);
    }else if(value.equals(cekBox12.getText())){
        cekBox12.setSelected(true);
    }else if(value.equals(cekBox6.getText())){
        cekBox6.setSelected(true);
    }
}
}
