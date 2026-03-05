using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;

namespace AspNetCore;

public class Server
{
    public static void Main(string[] args)
    {
        var builder = WebApplication.CreateBuilder(args);
        builder.WebHost.ConfigureKestrel(options =>
        {
            /* date header cannot be cleared in aspnet core */
            options.AddServerHeader = false;
        });
        var app = builder.Build();
        app.MapGet("/text", () => "Hello, World!");
        app.MapGet("/json", () => new
        {
            Message = "Hello, World!"
        });
        app.Run("http://0.0.0.0:8099");
    }
}
