const KEYWORDS = new Set([
  "abstract","assert","break","case","catch","class","const","continue","default",
  "do","else","enum","extends","final","finally","for","goto","if","implements",
  "import","instanceof","interface","native","new","package","private","protected",
  "public","return","static","strictfp","super","switch","synchronized","this",
  "throw","throws","transient","try","void","volatile","while","var","record","yield"
]);

const TYPES = new Set([
  "int","long","short","byte","char","boolean","float","double",
  "String","Integer","Long","Short","Byte","Character","Boolean","Float","Double",
  "List","ArrayList","LinkedList","Map","HashMap","TreeMap","LinkedHashMap","Set",
  "HashSet","TreeSet","LinkedHashSet","Queue","Deque","ArrayDeque","PriorityQueue",
  "Stack","Object","Collection","Iterator","Comparator","Comparable","Optional",
  "StringBuilder","StringBuffer","Arrays","Collections","Stream","IntStream"
]);

function escapeHtml(s) {
  return s.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;");
}

function highlight(code) {
  const tokenRe = /(\/\/[^\n]*)|(\/\*[\s\S]*?\*\/)|("(?:\\.|[^"\\])*")|('(?:\\.|[^'\\])*')|(@\w+)|(\b\d+(?:\.\d+)?[lLfFdD]?\b)|(\b[A-Za-z_]\w*\b)/g;
  let out = "";
  let lastIndex = 0;
  let m;
  while ((m = tokenRe.exec(code)) !== null) {
    out += escapeHtml(code.slice(lastIndex, m.index));
    const [full, comment, blockComment, str, chr, ann, num, word] = m;
    if (comment || blockComment) {
      out += `<span class="tok-com">${escapeHtml(full)}</span>`;
    } else if (str || chr) {
      out += `<span class="tok-str">${escapeHtml(full)}</span>`;
    } else if (ann) {
      out += `<span class="tok-ann">${escapeHtml(full)}</span>`;
    } else if (num) {
      out += `<span class="tok-num">${escapeHtml(full)}</span>`;
    } else if (word) {
      if (KEYWORDS.has(word)) out += `<span class="tok-kw">${escapeHtml(full)}</span>`;
      else if (TYPES.has(word)) out += `<span class="tok-type">${escapeHtml(full)}</span>`;
      else out += escapeHtml(full);
    }
    lastIndex = tokenRe.lastIndex;
  }
  out += escapeHtml(code.slice(lastIndex));
  return out;
}

const treeEl = document.getElementById("tree");
const codeContent = document.getElementById("code-content");
const codeArea = document.getElementById("code-area");
const emptyState = document.getElementById("empty-state");
const breadcrumb = document.getElementById("breadcrumb");
const copyBtn = document.getElementById("copy-btn");
const searchInput = document.getElementById("search");
const sidebar = document.getElementById("sidebar");
const backdrop = document.getElementById("sidebar-backdrop");
const menuToggle = document.getElementById("menu-toggle");

let activeFileEl = null;

function buildNode(node) {
  if (node.type === "folder") {
    const details = document.createElement("details");
    details.className = "folder";
    const summary = document.createElement("summary");
    summary.innerHTML = `<span class="folder-icon">&#128193;</span>${escapeHtml(node.name)}`;
    details.appendChild(summary);
    const ul = document.createElement("ul");
    node.children.forEach((child) => {
      const li = document.createElement("li");
      li.appendChild(buildNode(child));
      ul.appendChild(li);
    });
    details.appendChild(ul);
    return details;
  } else {
    const div = document.createElement("div");
    div.className = "file-item";
    div.dataset.path = node.path;
    div.innerHTML = `<span class="file-icon">&#128196;</span>${escapeHtml(node.name)}`;
    div.addEventListener("click", () => openFile(node.path, div));
    return div;
  }
}

function openFile(path, el) {
  const code = FILE_CONTENTS[path];
  if (code === undefined) return;
  codeContent.innerHTML = highlight(code);
  emptyState.style.display = "none";
  codeArea.style.display = "block";
  breadcrumb.textContent = "com.company/" + path;
  copyBtn.style.display = "inline-block";
  copyBtn.onclick = () => {
    navigator.clipboard.writeText(code).then(() => {
      copyBtn.textContent = "Copied!";
      setTimeout(() => (copyBtn.textContent = "Copy"), 1200);
    });
  };
  if (activeFileEl) activeFileEl.classList.remove("active");
  el.classList.add("active");
  activeFileEl = el;
  closeSidebarOnMobile();
  codeArea.scrollTop = 0;
}

treeEl.appendChild(buildNode(FILE_TREE));

// search filter
searchInput.addEventListener("input", () => {
  const q = searchInput.value.trim().toLowerCase();
  const allFiles = treeEl.querySelectorAll(".file-item");
  const allFolders = treeEl.querySelectorAll(".folder");

  if (!q) {
    allFiles.forEach((f) => f.classList.remove("hidden"));
    allFolders.forEach((f) => {
      f.classList.remove("hidden");
      f.open = false;
    });
    return;
  }

  allFolders.forEach((f) => (f.open = false));
  allFiles.forEach((f) => {
    const match = f.dataset.path.toLowerCase().includes(q);
    f.classList.toggle("hidden", !match);
    if (match) {
      let p = f.closest("ul");
      while (p) {
        const folder = p.parentElement;
        if (folder && folder.classList.contains("folder")) {
          folder.classList.remove("hidden");
          folder.open = true;
          p = folder.closest("ul");
        } else break;
      }
    }
  });

  allFolders.forEach((folder) => {
    const anyVisible = !!folder.querySelector(".file-item:not(.hidden)");
    folder.classList.toggle("hidden", !anyVisible);
  });
});

// mobile sidebar toggle
function closeSidebarOnMobile() {
  if (window.innerWidth <= 820) {
    sidebar.classList.remove("open");
    backdrop.classList.remove("open");
  }
}

menuToggle.addEventListener("click", () => {
  sidebar.classList.toggle("open");
  backdrop.classList.toggle("open");
});

backdrop.addEventListener("click", () => {
  sidebar.classList.remove("open");
  backdrop.classList.remove("open");
});
