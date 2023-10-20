<?php
require_once 'db_info.php';

$query = "SELECT * FROM books";
$result = mysqli_query($connection, $query);

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Management System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .header {
            background-color: #343a40;
            color: #fff;
            padding: 20px;
        }
        .book-container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            margin-top: 20px;
        }
        .book-actions {
            text-align: right;
        }
        .book-actions a {
            margin-left: 10px;
        }
    </style>
</head>
<body>
    <div class="header">
        <div class="container text-right">
            <h1 class="text-center">Library Management System</h1>
            <a href="add_book.php" class="btn btn-primary btn-sm">Add Book</a>
        </div>
    </div>
    <div class="container">
        <div class="book-container">
            <h2>Book Listing</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Publication Date</th>
                        <th>ISBN</th>
                        <th class="book-actions">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <?php while ($row = mysqli_fetch_assoc($result)) { ?>
                        <tr>
                            <td><?= $row['title'] ?></td>
                            <td><?= $row['author'] ?></td>
                            <td><?= $row['publication_date'] ?></td>
                            <td><?= $row['isbn'] ?></td>
                            <td>
                                <a href="edit_book.php?id=<?= $row['id'] ?>" class="btn btn-sm btn-primary">Edit</a>
                                <a href="delete_book.php?id=<?= $row['id'] ?>" class="btn btn-sm btn-danger">Delete</a>
                            </td>
                        </tr>
                    <?php } ?> 
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
