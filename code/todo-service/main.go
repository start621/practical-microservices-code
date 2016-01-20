package main

import (
	"encoding/json"
	"github.com/gorilla/mux"
	"github.com/owainlewis/practical-microservices/code/todo-service/todos"
	"log"
	"net/http"
)

func main() {
	router := mux.NewRouter()
	
	router.HandleFunc("/todos", TodosHandler).Methods("GET")
	router.HandleFunc("/todos/{id}", TodoHandler).Methods("GET")

	log.Fatal(http.ListenAndServe(":8080", router))
}

func TodosHandler(w http.ResponseWriter, r *http.Request) {
	
	a := todos.NewTodo("Write a service", "", false)
	todos := []*todos.Todo{a}
	json, _ := json.Marshal(todos)
	
	w.Header().Set("Content-Type", "application/json")
	w.Write(json)
}

func TodoHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	vars := mux.Vars(r)
	id := vars["id"]
	w.Write([]byte(id))
}
