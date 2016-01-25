#!/usr/bin/env ruby
# encoding: utf-8

require "bunny"
require "json"

HOST = "192.168.99.100"

conn = Bunny.new("amqp://guest:guest@#{HOST}:5672")
conn.start

ch   = conn.create_channel
q    = ch.queue("user.service")

puts " [*] Waiting for messages in #{q.name}. To exit press CTRL+C"

q.subscribe(:block => true) do |delivery_info, properties, body|
    
  payload = JSON.parse(body, :symbolize_names => true)

  if payload[:name] == 'user.created'
    puts "[x] SENDING USER WELCOME EMAIL"
  else
    puts "[x] Event #{body}"
  end       
end
