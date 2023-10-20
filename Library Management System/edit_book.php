<?php
require_once 'db_info.php';

if ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['id'])) {
    $bookId = $_GET['id'];
    $checkQuery = "SELECT * FROM books WHERE id = $bookId";
    $checkResult = mysqli_query($connection, $checkQuery);
    if (mysqli_num_rows($checkResult) > 0) {
        $book = mysqli_fetch_assoc($checkResult);
    } else {
        echo "Book not found.";
        exit;
    }
} elseif ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['id'])) {
    $bookId = $_POST['id'];
    $title = $_POST['title'];
    $author = $_POST['author'];
    $publication_date = $_POST['publication_date'];
    $isbn = $_POST['isbn'];
    $updateQuery = "UPDATE books SET title = '$title', author = '$author', publication_date = '$publication_date', isbn = '$isbn' WHERE id = $bookId";
    if (mysqli_query($connection, $updateQuery)) {
        header('Location: index.php');
        exit;
    } else {
        echo "Error updating book: " . mysqli_error($connection);
    }
} else {
    echo "Invalid request.";
    exit;
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Book</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Edit Book</h1>
        <form method="post" action="edit_book.php">
            <input type="hidden" name="id" value="<?= $book['id'] ?>">
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" class="form-control" id="title" name="title" value="<?= $book['title'] ?>" required>
            </div>
            <div class="form-group">
                <label for="author">Author</label>
                <input type="text" class="form-control" id="author" name="author" value="<?= $book['author'] ?>" required>
            </div>
            <div class="form-group">
                <label for="publication_date">Publication Date</label>
                <input type="date" class="form-control" id="publication_date" name="publication_date" value="<?= $book['publication_date'] ?>" required>
            </div>
            <div class="form-group">
                <label for="isbn">ISBN</label>
                <input type="text" class="form-control" id="isbn" name="isbn" value="<?= $book['isbn'] ?>" required>
            </div>
            <button type="submit" class="btn btn-primary">Update Book</button>
        </form>
    </div>
</body>
</html>

