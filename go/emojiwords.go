package main

import (
	"fmt"
	"os"
	"os/exec"
)

func main() {

	word := os.Args[1]
	emoji := os.Args[2]
	gap := ":empty:"
	emo := fmt.Sprintf(":%s:", emoji)
	letterMap := mapCreation(gap, emo)

	var result string

	for i := 0; i < 5; i++ {
		for letter := range word {
			var dynamicGap string
			if(letter == len(word) - 1) {
				dynamicGap = ""
			} else {
				dynamicGap = gap
			}
			result = result + letterMap[string(word[letter])][i] + dynamicGap
		}
		if(i < 4) {
			result = result + "\n"
		}
	}

	copyToClipboard(result)
}

func mapCreation(gap string, emo string) map[string][5]string {
	letterMap := make(map[string][5]string)

	letterMap["a"] = [5]string{gap + emo + emo + gap, emo + gap + gap + emo, emo + emo + emo + emo, emo + gap + gap + emo, emo + gap + gap + emo}
	letterMap["b"] = [5]string{emo + emo + emo + gap, emo + gap + gap + emo, emo + emo + emo + emo, emo + gap + gap + emo, emo + emo + emo + gap}
	letterMap["c"] = [5]string{emo + emo + emo + emo, emo + gap + gap + gap, emo + gap + gap + gap, emo + gap + gap + gap, emo + emo + emo + emo}
	letterMap["d"] = [5]string{emo + emo + emo + gap, emo + gap + gap + emo, emo + gap + gap + emo, emo + gap + gap + emo, emo + emo + emo + gap}
	letterMap["e"] = [5]string{emo + emo + emo + emo, emo + gap + gap + gap, emo + emo + emo + emo, emo + gap + gap + gap, emo + emo + emo + emo}
	letterMap["f"] = [5]string{emo + emo + emo + emo, emo + gap + gap + gap, emo + emo + emo + emo, emo + gap + gap + gap, emo + gap + gap + gap}
	letterMap["g"] = [5]string{emo + emo + emo + emo, emo + gap + gap + gap, emo + gap + emo + emo, emo + gap + gap + emo, emo + emo + emo + emo}
	letterMap["h"] = [5]string{emo + gap + gap + emo, emo + gap + gap + emo, emo + emo + emo + emo, emo + gap + gap + emo, emo + gap + gap + emo}
	letterMap["i"] = [5]string{emo, emo, emo, emo, emo}
	letterMap["j"] = [5]string{emo + emo + emo + emo, gap + gap + emo + gap, gap + gap + emo + gap, emo + gap + emo + gap, emo + emo + emo + gap}
	letterMap["k"] = [5]string{emo + gap + gap + emo, emo + gap + emo + gap, emo + emo + gap + gap, emo + gap + emo + gap, emo + gap + gap + emo}
	letterMap["l"] = [5]string{emo + gap + gap + gap, emo + gap + gap + gap, emo + gap + gap + gap, emo + gap + gap + gap, emo + emo + emo + emo}
	letterMap["m"] = [5]string{emo + gap + gap + gap + emo, emo + emo + gap + emo + emo, emo + gap + emo + gap + emo, emo + gap + gap + gap + emo, emo + gap + gap + gap + emo}
	letterMap["n"] = [5]string{emo + gap + gap + gap + emo, emo + emo + gap + gap + emo, emo + gap + emo + gap + emo, emo + gap + gap + emo + emo, emo + gap + gap + gap + emo}
	letterMap["o"] = [5]string{emo + emo + emo + emo, emo + gap + gap + emo, emo + gap + gap + emo, emo + gap + gap + emo, emo + emo + emo + emo}
	letterMap["p"] = [5]string{emo + emo + emo + emo, emo + gap + gap + emo, emo + emo + emo + emo, emo + gap + gap + gap, emo + gap + gap + gap}
	letterMap["q"] = [5]string{emo + emo + emo + emo + emo, emo + gap + gap + gap + emo, emo + gap + gap + gap + emo, emo + gap + gap + emo + emo, emo + emo + emo + emo + emo}
	letterMap["r"] = [5]string{emo + emo + emo + emo, emo + gap + gap + emo, emo + emo + emo + emo, emo + gap + emo + gap, emo + gap + gap + emo}
	letterMap["s"] = [5]string{emo + emo + emo + emo, emo + gap + gap + gap, emo + emo + emo + emo, gap + gap + gap + emo, emo + emo + emo + emo}
	letterMap["t"] = [5]string{emo + emo + emo + emo + emo, gap + gap + emo + gap + gap, gap + gap + emo + gap + gap, gap + gap + emo + gap + gap, gap + gap + emo + gap + gap}
	letterMap["u"] = [5]string{emo + gap + gap + emo, emo + gap + gap + emo, emo + gap + gap + emo, emo + gap + gap + emo, emo + emo + emo + emo}
	letterMap["v"] = [5]string{emo + gap + gap + gap + emo, emo + gap + gap + gap + emo, emo + gap + gap + gap + emo, gap + emo + gap + emo + gap, gap + gap + emo + gap + gap}
	letterMap["w"] = [5]string{emo + gap + gap + gap + emo, emo + gap + gap + gap + emo, emo + gap + gap + gap + emo, emo + gap + emo + gap + emo, emo + emo + gap + emo + emo}
	letterMap["x"] = [5]string{emo + gap + gap + gap + emo, gap + emo + gap + emo + gap, gap + gap + emo + gap + gap, gap + emo + gap + emo + gap, emo + gap + gap + gap + emo}
	letterMap["y"] = [5]string{emo + gap + gap + gap + emo, gap + emo + gap + emo + gap, gap + gap + emo + gap + gap, gap + gap + emo + gap + gap, gap + gap + emo + gap + gap}
	letterMap["z"] = [5]string{emo + emo + emo + emo + emo, gap + gap + gap + emo + gap, gap + gap + emo + gap + gap, gap + emo + gap + gap + gap, emo + emo + emo + emo + emo}
	letterMap[" "] = [5]string{gap, gap, gap, gap, gap}

	return letterMap
}

func copyToClipboard(text string) error {
	copyCommand := exec.Command("pbcopy")
	in, err := copyCommand.StdinPipe()
	if err != nil {
		return err
	}

	if err := copyCommand.Start(); err != nil {
		return err
	}
	if _, err := in.Write([]byte(text)); err != nil {
		return err
	}
	if err := in.Close(); err != nil {
		return err
	}
	return copyCommand.Wait()
}
