FROM mcr.microsoft.com/dotnet/aspnet:10.0
RUN apt-get update && apt-get install -y curl
WORKDIR /app
COPY app/* ./
ENTRYPOINT [ "dotnet", "aspnetcore.dll" ]
