#!/usr/bin/bash

curr_dir="${PWD}"

function run_package()
{
  dir="$1"
  echo "##################################################"
  echo "# Packaging ${dir}                                "
  echo "##################################################"
  cd "${dir}" && ./package.sh
  cd "${curr_dir}"
}

run_package libevhtp
run_package drogon
run_package beast
run_package gin
run_package gofiber
run_package hertz
run_package springboot/spring-webflux
run_package springboot/spring-webmvc
run_package springboot/spring-webmvc-undertow
