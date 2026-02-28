package main

import (
	"context"
	"github.com/cloudwego/hertz/pkg/app"
	"github.com/cloudwego/hertz/pkg/app/server"
	"github.com/cloudwego/hertz/pkg/common/utils"
	"github.com/cloudwego/hertz/pkg/protocol/consts"
	"log"
)

/*
 * Cross build with:
 * # GOOS=linux GOARCH=amd64 go build hertz_server.go
 */
func main() {
	addr := ":8099"
	h := server.Default(
		server.WithHostPorts(addr),
		server.WithDisableDefaultDate(true))
	h.Use(func(c context.Context, ctx *app.RequestContext) {
		ctx.Next(c)
		ctx.Response.Header.Del("Server")
	})
	h.GET("/text", func(ctx context.Context, c *app.RequestContext) {
		c.Data(consts.StatusOK, consts.MIMETextPlain, []byte("Hello, World!"))
		//c.String(consts.StatusOK, "Hello, World!")
	})
	h.GET("/json", func(ctx context.Context, c *app.RequestContext) {
		c.JSON(consts.StatusOK, utils.H{"Message": "Hello, World!"})
	})
	log.Printf("Starting hertz server at %s..", addr)
	h.Spin()
}
