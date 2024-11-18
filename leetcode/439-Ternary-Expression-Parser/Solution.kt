class Solution {
    fun parseTernary(expression: String): String {
        val stack = ArrayDeque<Char>()
        val i = expression.length - 1

        while (i >= 0) {
            val char = expression[i]
            when {
                char == '?' -> {
                    val onTrue = stack.removeLast()
                    val onFalse = stack.removeLast()
                    val condition = expression[--i]
                    stack.addLast(if (condition == 'T') onTrue else onFalse)
                }
                char.isDigit() || char == 'T' || char == 'F' -> {
                    stack.addLast(char)
                }
            }
            i--
        }
        return stack.removeLast().toString()
    }
}