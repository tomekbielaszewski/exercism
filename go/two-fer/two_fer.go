package twofer

import "fmt"

//ShareWith function returns string according to well known exercise "Two-fer"
//
//Function returns string "One for you, one for me." when name arg is empty or
//"One for X, one for me." when name arg = X
func ShareWith(name string) string {
	if name == "" {
		name = "you"
	}
	return fmt.Sprintf("One for %s, one for me.", name)
}
