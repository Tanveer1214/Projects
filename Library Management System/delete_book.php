<?php
require_once 'db_info.php';

if($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['id'])) {
    $bookId = $_GET['id'];
    $checkQuery = "SELECT id FROM books WHERE id = $bookId";
    $checkResult = mysqli_query($connection, $checkQuery);

    if (mysqli_num_rows($checkResult) > 0) {
        $deleteQuery = "DELETE FROM books WHERE id = $bookId";
        if (mysqli_query($connection, $deleteQuery)) {
            header('Location: index.php');
            exit;
        } else {
            echo "Error deleting book: " . mysqli_error($connection);
        }
    } else {
        echo "Book not found.";
    }
} else {
    echo "Invalid request.";
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
    <div class="container mt-5">
        <h1>Delete Book</h1>
    </div>
</body>
</html>
