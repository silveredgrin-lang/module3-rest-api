export function isValidTitle(value) {
  return typeof value === "string" && value.trim().length > 0;
}
