package labbuoi4;
import java.util.ArrayList;
import java.util.Scanner;

class Xe { protected String soxe;
    protected String loai;
    protected String ngaydk;
    protected boolean trthai;
    public Xe() {
        this.soxe = "";
        this.loai = "";
        this.ngaydk = "";
        this.trthai = false;
    }public Xe(Xe x) {
        this.soxe = x.soxe;
        this.loai = x.loai;
        this.ngaydk = x.ngaydk;
        this.trthai = x.trthai;
    } public void nhap(Scanner sc) {
        System.out.print("Nhap so xe: ");
        soxe = sc.nextLine();
        System.out.print("Nhap loai xe: ");
        loai = sc.nextLine();
        System.out.print("Nhap ngay dang kiem (dd-mm-yyyy): ");
        ngaydk = sc.nextLine();
        System.out.print("Trang thai (true: duoc phep, false: khong duoc phep): ");
        trthai = Boolean.parseBoolean(sc.nextLine());
    }public void in() {
        System.out.println("So xe: " + soxe);
        System.out.println("Loai xe: " + loai);
        System.out.println("Ngay dang kiem: " + ngaydk);
        System.out.println("Trang thai: " + (trthai ? "Duoc phep" : "Khong duoc phep"));
    }public boolean getTrangThai() {
        return trthai;
    }
    public String getLoai() {
        return loai;
    }public String getNgaydk() {
        return ngaydk;
    }
}
class ChuyenXe extends Xe { private int msc;
    private String ten;
    private String noiden;
    private double doanhthu;
    public ChuyenXe() {
        super();
        this.msc = 0;
        this.ten = "";
        this.noiden = "";
        this.doanhthu = 0.0;
    }@Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap ma so chuyen: ");
        msc = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap ten nguoi lai: ");
        ten = sc.nextLine();
        System.out.print("Nhap noi den: ");
        noiden = sc.nextLine();
        System.out.print("Nhap doanh thu: ");
        doanhthu = Double.parseDouble(sc.nextLine());
    }
    @Override
    public void in() {
        super.in();
        System.out.println("Ma so chuyen: " + msc);
        System.out.println("Ten nguoi lai: " + ten);;
        System.out.println("Noi den: " + noiden);
        System.out.println("Doanh thu: " + doanhthu);}

    public int getMsc() {
        return msc;}
    public double getDoanhThu() {
        return doanhthu;
    }

    public double loiNhuan() {
        return 0.3 * doanhthu;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Kiem tra lop Xe ");
        Xe x1 = new Xe();
        System.out.println("thoông tin xe  x1:");
        x1.nhap(sc);
        System.out.println("Thong tin xe x1:");
        x1.in();
        Xe x2 = new Xe(x1);
        System.out.println("Thong tin xe x2:");
        x2.in();
        System.out.println("\nKiem tra lop ChuyenXe");
        System.out.print("s; chuyen xe: ");
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<ChuyenXe> ds = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            System.out.println("\nthoong tin chuyeýen xe thứ" + (i + 1) + ":");
            ChuyenXe cx = new ChuyenXe();
            cx.nhap(sc);
            ds.add(cx);}
        System.out.println("\nthong tin cac chuyen xe:");
        for (int i = 0; i < m; i++) {
            System.out.println("\nChuyen xe thu " + (i + 1) + ":");
            ds.get(i).in();}
        System.out.println("\n Cac chuyen xe bi huy");
        boolean coHuy = false;
        for (ChuyenXe cx : ds) {
            if (!cx.getTrangThai() || cx.getDoanhThu() < 100000) {
                System.out.println("Ms chuyen bi huy " + cx.getMsc());;
                coHuy = true;}}
        if (!coHuy) {
            System.out.println("k co chuyen xe nao bi huyr");
        }
        System.out.println("\n tong loi nhuaanj");
        System.out.print("ngay cantinh: ");
        String thangNam = sc.nextLine();
        double tongLoiNhuan = 0;
        for (ChuyenXe cx : ds) {
            if (cx.getTrangThai() && cx.getDoanhThu() >= 100000) {
                if (cx.getNgaydk().substring(3).equals(thangNam.substring(3))) {
                    tongLoiNhuan += cx.loiNhuan();
                }
            }
        }
        System.out.println("Tong loi nhuan theo thang-nam " + thangNam + " la: " + tongLoiNhuan);}
}