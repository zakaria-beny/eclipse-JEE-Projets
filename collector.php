<?php
// collector.php
$dataFile = __DIR__ . '/data.json';

// Initialize storage file if missing
if (!file_exists($dataFile)) {
    file_put_contents($dataFile, json_encode([]));
}

// Handle POST requests to /collect
if ($_SERVER['REQUEST_METHOD'] === 'POST' && $_SERVER['REQUEST_URI'] === '/collect') {
    header('Content-Type: application/json');

    $raw = file_get_contents('php://input');
    $json = json_decode($raw, true);

    if ($json === null) {
        http_response_code(400);
        echo json_encode(['error' => 'Invalid JSON']);
        exit;
    }

    $entries = json_decode(file_get_contents($dataFile), true);
    $entries[] = [
        'timestamp' => date('Y-m-d H:i:s'),
        'payload'   => $json
    ];

    file_put_contents($dataFile, json_encode($entries, JSON_PRETTY_PRINT));

    echo json_encode(['status' => 'stored']);
    exit;
}

// Default UI (GET /)
$entries = json_decode(file_get_contents($dataFile), true);
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Local JSON Collector</title>
    <style>
        body { font-family: monospace; background: #f5f5f5; padding: 20px; }
        pre { background: #fff; padding: 10px; border: 1px solid #ccc; }
    </style>
</head>
<body>
<h2>Stored JSON Payloads</h2>

<?php if (empty($entries)): ?>
    <p>No data collected yet.</p>
<?php else: ?>
    <?php foreach ($entries as $entry): ?>
        <pre><?= htmlspecialchars(json_encode($entry, JSON_PRETTY_PRINT)) ?></pre>
    <?php endforeach; ?>
<?php endif; ?>

</body>
</html>
