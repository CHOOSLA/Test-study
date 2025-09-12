 //
//  ContentView.swift
//  VoteListRestApi
//
//  Created by choosla on 9/12/25.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
      NavigationStack{
        VoteListView()
      }
    }
}

struct VoteListView: View{
  @StateObject private var viewModel = VoteViewModel()
  
  var body : some View{
    List(viewModel.votes) { vote in
      NavigationLink{
        VoteView(vote: vote)
      } label : {
        Text(vote.title)
      }
    }
    .navigationTitle("투표 목록 화면")
    .task {
      await viewModel.fetchVotes()
    }
    .toolbar {
      ToolbarItem(placement: .navigationBarTrailing) {
        NavigationLink {
          AddVoteView(viewModel : viewModel)
        } label : {
          Image(systemName : "plus")
        }
      }
    }
  }
}

import PhotosUI

struct AddVoteView: View {
  @Environment(\.dismiss) private var dismiss
  @ObservedObject var viewModel : VoteViewModel
  
  @State private var title : String = ""
  @State private var description : String = ""
  
  @State private var selectedItem: PhotosPickerItem? = nil
  @State private var selectedImage: UIImage? = nil
  
  var body: some View {
    Form{
      TextField("투표 제목", text : $title)
      TextField("투표 설명", text : $description)
      
      Button("저장"){
        Task{
          await viewModel.addVote(title: title, description: description, image: selectedImage)
          dismiss()
        }
      }
      
      if let image = selectedImage{
        Image(uiImage: image)
          .resizable()
          .scaledToFit()
          .frame(height: 200)
          .cornerRadius(12)
      } else {
        Rectangle()
          .fill(Color.gray.opacity(0.3))
          .frame(height: 300)
          .cornerRadius(12)
          .overlay(Text("사진 없음"))
      }
      
      PhotosPicker(
        selection: $selectedItem,
        matching: .images,
        photoLibrary: .shared()
      ){
        Text("앨범에서 선택")
      }
      .onChange(of: selectedItem) { item in
        Task{
          if let data = try? await item?.loadTransferable(type: Data.self),
              let uiImage = UIImage(data: data){
            selectedImage = uiImage
          }
        }
      }
      .navigationTitle("투표 생성 화면")
    }
  }
}

struct VoteView: View{
  let vote : Vote
  
  var body: some View{
    VStack {
      Text(vote.title)
      Text(vote.description)
    }
    .padding()
    .navigationTitle("투표화면")
  }
}

#Preview {
    ContentView()
}
