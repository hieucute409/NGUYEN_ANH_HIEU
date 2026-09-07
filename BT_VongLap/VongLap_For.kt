fun main()
{
    // Vong lap For 
    // Bai 1: In các số từ 1 đến 10
    println(" In cac so tu 1 _ 10 ")
    for(i in 1..10)
    {
        print(" $i")
    }

    // Bai 2: Tính tổng 1 + 2 + ... + 100
    var sum = 0
    for (i in 1..100)
    {
        sum += i
    }
    print("\n Tong la: $sum")   
    println()

    // Bai 3: In các số chẵn từ 1 đến 20
    println(" In cac so chan tu 1 _ 20 ")
    for(i in 2..20 step 2)
    {
        print(" $i")
    }
}