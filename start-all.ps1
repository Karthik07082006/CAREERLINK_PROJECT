$root = $PSScriptRoot

function Start-Service {
    param (
        [string]$Name
    )

    $path = Join-Path $root $Name

    Write-Host "Starting $Name..."

    Start-Process powershell.exe -ArgumentList `
        "-NoExit", `
        "-Command", `
        "Set-Location '$path'; mvn spring-boot:run"
}

Start-Service "CareerLinkEurekaServer"

Start-Sleep -Seconds 15

Start-Service "CareerLinkAuthService"
Start-Service "CareerLinkApplicationService"
Start-Service "CareerLinkJobService"
Start-Service "CareerLinkProfileService"

Start-Sleep -Seconds 15

Start-Service "CareerLinkAPIGateway"

Write-Host ""
Write-Host "All CareerLink services started."