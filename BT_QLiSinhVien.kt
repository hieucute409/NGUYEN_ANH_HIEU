import java.util.Scanner

data class Student(val id: String, val name: String, val age: Int, val major: String, val gpa: Double)

class StudentManagement {
    private val students = mutableListOf(
        Student("SV101", "Hoang Dinh Nam", 21, "Automotive", 8.4),
        Student("SV102", "Dang Phan Khanh Linh", 19, "IT", 4.5),
        Student("SV103", "Bui Huu Phuoc", 23, "Electrical", 9.1),
        Student("SV104", "Tran Bao Duy", 20, "IT", 7.6),
        Student("SV105", "Nguyen Thi Tuyet Mai", 22, "Business", 6.8)
    )
    private val scanner = Scanner(System.`in`)

    private fun readInput(): String {
        return if (scanner.hasNextLine()) scanner.nextLine() else ""
    }

    fun start() {
        while (true) {
            println("\n========== STUDENT MANAGEMENT ==========")
            println("1. Show list | 2. Add | 3. Remove")
            println("4. Search menu | 5. Stats menu | 6. Advanced features")
            println("0. Exit")
            print("Choice: ")
            
            val input = readInput()
            if (input.isEmpty()) break

            when (input) {
                "1" -> show(students)
                "2" -> add()
                "3" -> remove()
                "4" -> searchMenu()
                "5" -> statsMenu()
                "6" -> advancedMenu()
                "0" -> return
                else -> println("Invalid choice!")
            }
        }
    }

    private fun show(list: List<Student>) {
        if (list.isEmpty()) {
            println("List is empty.")
            return
        }
        println("\n%-7s | %-22s | %-5s | %-12s | %-5s".format("ID", "Full Name", "Age", "Major", "GPA"))
        println("-".repeat(62))
        for (s in list) {
            println("%-7s | %-22s | %-5d | %-12s | %.2f".format(s.id, s.name, s.age, s.major, s.gpa))
        }
    }

    private fun add() {
        print("Enter ID: "); val id = readInput()
        print("Enter Name: "); val name = readInput()
        print("Enter Age: "); val age = readInput().toIntOrNull() ?: 0
        print("Enter Major: "); val major = readInput()
        print("Enter GPA: "); val gpa = readInput().toDoubleOrNull() ?: 0.0

        students.add(Student(id, name, age, major, gpa))
        println("Added successfully!")
    }

    private fun remove() {
        print("Enter ID to remove: ")
        val id = readInput()
        if (students.removeIf { it.id.equals(id, ignoreCase = true) }) {
            println("Removed successfully!")
        } else {
            println("ID not found.")
        }
    }

    private fun searchMenu() {
        println("\n--- SEARCH MENU ---")
        println("1. By ID or Name | 2. By Partial Name | 3. By Major | 4. GPA in range [7.0 - 8.5]")
        print("Choose: ")
        when (readInput().toIntOrNull()) {
            1 -> {
                print("Enter keyword: ")
                val kw = readInput().toLowerCase()
                show(students.filter { it.id.toLowerCase().contains(kw) || it.name.toLowerCase().contains(kw) })
            }
            2 -> {
                print("Enter partial name: ")
                val kw = readInput().toLowerCase()
                show(students.filter { it.name.toLowerCase().contains(kw) })
            }
            3 -> {
                print("Enter Major: ")
                val major = readInput()
                show(students.filter { it.major.equals(major, ignoreCase = true) })
            }
            4 -> show(students.filter { it.gpa in 7.0..8.5 })
            else -> println("Invalid choice.")
        }
    }

    private fun statsMenu() {
        println("\n--- STATS MENU ---")
        println("1. Average GPA (All) | 2. Average GPA (Major) | 3. Highest GPA | 4. Oldest student")
        print("Choose: ")
        when (readInput().toIntOrNull()) {
            1 -> {
                if (students.isNotEmpty()) println("Average GPA: %.2f".format(students.map { it.gpa }.average()))
                else println("List is empty.")
            }
            2 -> {
                print("Enter Major: ")
                val major = readInput()
                val list = students.filter { it.major.equals(major, ignoreCase = true) }
                if (list.isNotEmpty()) println("Average GPA for $major: %.2f".format(list.map { it.gpa }.average()))
                else println("No students found in major $major.")
            }
            3 -> {
                val best = students.maxBy { it.gpa }
                if (best != null) show(listOf(best)) else println("List is empty.")
            }
            4 -> {
                val oldest = students.maxBy { it.age }
                if (oldest != null) show(listOf(oldest)) else println("List is empty.")
            }
            else -> println("Invalid choice.")
        }
    }

    private fun advancedMenu() {
        println("\n--- ADVANCED FEATURES ---")
        println("1. Count GPA >= 8.0")
        println("2. Count GPA < 5.0")
        println("3. Sort by GPA descending")
        println("4. Top 3 highest GPA")
        println("5. Sort by Age ascending")
        println("6. Sort by Name alphabetically")
        print("Choose: ")
        when (readInput().toIntOrNull()) {
            1 -> println("Count GPA >= 8.0: ${students.count { it.gpa >= 8.0 }}")
            2 -> println("Count GPA < 5.0: ${students.count { it.gpa < 5.0 }}")
            3 -> show(students.sortedByDescending { it.gpa })
            4 -> show(students.sortedByDescending { it.gpa }.take(3))
            5 -> show(students.sortedBy { it.age })
            6 -> show(students.sortedBy { it.name })
            else -> println("Invalid choice.")
        }
    }
}

fun main() {
    StudentManagement().start()
}