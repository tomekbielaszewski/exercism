package acronym

import (
	"regexp"
	"strings"
)

var specialCharacters = regexp.MustCompile("[_\\-]+")

// Abbreviate generates acronym based on given sentence
func Abbreviate(s string) string {
	s = specialCharacters.ReplaceAllString(s, " ")
	split := strings.Split(s, " ")
	var acronym = ""
	for _, word := range split {
		if word != "" {
			acronym += strings.ToUpper(word[:1])
		}
	}
	return acronym
}
