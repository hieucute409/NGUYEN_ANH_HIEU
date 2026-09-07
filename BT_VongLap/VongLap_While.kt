fun main() {
    // Vong lap While 
    
    // Bai 1: In các số từ 1 đến 10
    println(" In cac so tu 1 _ 10 ")
    var i1 = 1
    while (i1 <= 10) {
        print(" $i1")
        i1++
    }

    // Bai 2: Tính tổng 1 + 2 + ... + 100
    var sum = 0
    var i2 = 1
    while (i2 <= 100) {
        sum += i2
        i2++
    }
    print("\n Tong la: $sum")   
    println()

    // Bai 3: In các số chẵn từ 1 đến 20
    println(" In cac so chan tu 1 _ 20 ")
    var i3 = 2
    while (i3 <= 20) {
        print(" $i3")
        i3 += 2
    }
}