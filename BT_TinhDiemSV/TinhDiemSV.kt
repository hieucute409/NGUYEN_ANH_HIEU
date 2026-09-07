import kotlin.math.max
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    // Thong tin sinh vien
    // Ten: Nguyen Anh Hieu
    // MSV: 2415053122113
    val name = scanner.nextLine()
    val math = scanner.nextDouble()
    val programming = scanner.nextDouble()
    val database = scanner.nextDouble()
    if (math !in 0.0..10.0 || programming !in 0.0..10.0 || database !in 0.0..10.0) 
        {
            println("Loi: Diem nhap vao phai nam trong khoang tu 0 den 10!")
            return
        }

    // Tinh toan
    val totalscore = math + programming + database
    val gpa = totalscore / 3.0
    val maxscore = max(math, max(database, programming))

    // In thong tin
    println("Ten sinh vien: $name")
    println("Tong diem: $totalscore")
    println("Diem trung binh: %.2f".format(gpa))
    println("Diem cao nhat: $maxscore")
    println("Ket qua: ${if (gpa >= 5) "Dat" else "Khong dat"}")
}