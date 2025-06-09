<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/calculate" method="post">
    <label>Left Operand:</label>
    <input type="text" name="left" required><br><br>

    <label>Operator:</label>
    <select name="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select><br><br>

    <label>Right Operand:</label>
    <input type="text" name="right" required><br><br>

    <button type="submit">Calculate</button>
</form>
