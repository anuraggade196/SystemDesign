#include<bits/stdc++.h>
using namespace std ;
class DocumentEditor{
    private :
    vector<string>DocumentElements ;
    string renderedDocument ;
    public :
    void addtext(string text){
        DocumentElements.push_back(text);

    }
     void addimage(string url){
        DocumentElements.push_back(url);

     }

         string renderDocument() {
        if(renderedDocument.empty()) {
            string result;
            for (auto element : DocumentElements) {
                if (element.size() > 4 && (element.substr(element.size() - 4) == ".jpg" ||
                 element.substr(element.size() - 4) == ".png")) {
                    result += "[Image: " + element + "]" + "\n";
                } else {
                    result += element + "\n";
                }
            }
            renderedDocument = result;
        }
        return renderedDocument;
    }
   void saveToFile() {
        ofstream file("document.txt");
        if (file.is_open()) {
            file << renderDocument();
            file.close();
            cout << "Document saved to document.txt" << endl;
        } else {
            cout << "Error: Unable to open file for writing." << endl;
        }
    }

};
int main(){
     DocumentEditor editor;
    editor.addtext("Hello, world!");
    editor.addimage("picture.jpg");
    editor.addtext("This is a document editor.");

    cout << editor.renderDocument() << endl;

    editor.saveToFile();
    
    return 0;


}